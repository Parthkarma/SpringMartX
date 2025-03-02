package com.ecommerce.project.service;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.model.Product;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.payload.ProductResponse;
import com.ecommerce.project.repositories.CategoryRepository;
import com.ecommerce.project.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @Value("${image.base.url}")
    private String imageBaseUrl;

    private String constructImageUrl(String imageName) {
        return imageBaseUrl.endsWith("/") ? imageBaseUrl + imageName : imageBaseUrl + "/" + imageName;
    }

    @Override
    public ProductDTO addProduct(Long categoryId, ProductDTO product) {
        return null;
    }

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<ProductResponse> getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder, String keyword, String category) {
        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Specification<Product> spec = Specification.where(null);

        if (keyword != null && !keyword.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                 criteriaBuilder.like(criteriaBuilder.lower(root.get("productName")), "%" + keyword.toLowerCase() + "%")
            );
        }

        if (category != null && !category.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                 criteriaBuilder.equal(root.get("category").get("categoryName"), category)
            );
        }

        Page<Product> productPage = productRepository.findAll(spec, pageable);

        List<ProductDTO> productDTOS = productPage.getContent().stream()
             .map(product -> {
                 ProductDTO dto = modelMapper.map(product, ProductDTO.class);
                 dto.setImage(constructImageUrl(product.getImage()));
                 return dto;
             }).toList();

        ProductResponse response = new ProductResponse(productDTOS, productPage.getNumber(), productPage.getSize(),
             productPage.getTotalElements(), productPage.getTotalPages(), productPage.isLast());

        return CompletableFuture.completedFuture(response);
    }

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<ProductResponse> searchByCategory(Long categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Category category = categoryRepository.findById(categoryId)
             .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Product> productPage = productRepository.findByCategoryOrderByPriceAsc(category, pageable);

        if (productPage.isEmpty()) {
            throw new APIException(category.getCategoryName() + " category does not have any products");
        }

        List<ProductDTO> productDTOS = productPage.getContent().stream()
             .map(product -> modelMapper.map(product, ProductDTO.class))
             .toList();

        ProductResponse response = new ProductResponse(productDTOS, productPage.getNumber(), productPage.getSize(),
             productPage.getTotalElements(), productPage.getTotalPages(), productPage.isLast());

        return CompletableFuture.completedFuture(response);
    }

    @Override
    public CompletableFuture<ProductResponse> searchProductByKeyword(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Product> productPage = productRepository.findByProductNameLikeIgnoreCase('%' + keyword + '%', pageable);

        if (productPage.isEmpty()) {
            throw new APIException("No products found with keyword: " + keyword);
        }

        List<ProductDTO> productDTOS = productPage.getContent().stream()
             .map(product -> modelMapper.map(product, ProductDTO.class))
             .toList();

        ProductResponse response = new ProductResponse(productDTOS, productPage.getNumber(), productPage.getSize(),
             productPage.getTotalElements(), productPage.getTotalPages(), productPage.isLast());

        return CompletableFuture.completedFuture(response);
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Product productFromDb = productRepository.findById(productId)
             .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

        modelMapper.map(productDTO, productFromDb);
        productFromDb.setSpecialPrice(productDTO.getPrice() - ((productDTO.getDiscount() * 0.01) * productDTO.getPrice()));

        Product updatedProduct = productRepository.save(productFromDb);

        return modelMapper.map(updatedProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
             .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

        productRepository.delete(product);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<ProductDTO> updateProductImage(Long productId, MultipartFile image) throws IOException {
        Product productFromDb = productRepository.findById(productId)
             .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

        String fileName = fileService.uploadImage(path, image);
        productFromDb.setImage(fileName);

        Product updatedProduct = productRepository.save(productFromDb);
        return CompletableFuture.completedFuture(modelMapper.map(updatedProduct, ProductDTO.class));
    }
}
