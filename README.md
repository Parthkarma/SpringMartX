# SpringMartX - E-Commerce Platform

## Overview
SpringMartX is a full-stack e-commerce platform built using **Spring Boot** for the backend and **React** for the frontend. This project provides a seamless shopping experience with features like product management, user authentication, shopping cart, and order processing.

### **Project Links:**
- **Backend Repository:** [SpringMartX (Spring Boot)](https://github.com/Parthkarma/SpringMartX)
- **Frontend Repository:** [SpringMartxUI (React)](https://github.com/Parthkarma/SpringMartxUI)
- **API Documentation:** [Postman API Docs](https://documenter.getpostman.com/view/33652413/2sAYX3sPPt)

## Features
### **Backend (Spring Boot - SpringMartX)**
- 🔐 **Authentication & Authorization** (JWT-based security)
- 📂 **Category Management** (CRUD operations on product categories)
- 🛍️ **Product Management** (Adding, updating, and deleting products)
- 🛒 **Cart Functionality** (Add to cart, update, and remove items)
- 📦 **Order Processing** (Placing orders and handling payments)
- 🛡️ **Security Features** (User authentication and role-based access control)

### **Frontend (React - SpringMartxUI)**
- **User Registration & Login Pages**
- **Product Listing & Filtering by Categories**
- **Shopping Cart with State Management (Redux)**
- **Checkout & Order Summary Pages**
- **Integration with Backend APIs**
- **Responsive & Modern UI Design**

## Technologies Used
### **Backend:**
- Java, Spring Boot
- Spring Security (JWT Authentication)
- MySQL/PostgreSQL
- REST APIs
- Maven

### **Frontend:**
- React.js
- Redux for State Management
- TailwindCSS / Material-UI (for styling)
- Axios (for API calls)
- React Router (for navigation)

## Getting Started
### **Backend Setup**
1. Clone the backend repository:
   ```bash
   git clone https://github.com/Parthkarma/SpringMartX.git
   ```
2. Navigate to the project directory:
   ```bash
   cd SpringMartX
   ```
3. Configure your database in `application.properties`.
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### **Frontend Setup**
1. Clone the frontend repository:
   ```bash
   git clone https://github.com/Parthkarma/SpringMartxUI.git
   ```
2. Navigate to the project directory:
   ```bash
   cd SpringMartxUI
   ```
3. Install dependencies:
   ```bash
   npm install
   ```
4. Start the React development server:
   ```bash
   npm start
   ```

## API Endpoints
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/auth/register` | POST | Register a new user |
| `/api/auth/login` | POST | User login & JWT generation |
| `/api/products` | GET | Fetch all products |
| `/api/products/{id}` | GET | Fetch a single product by ID |
| `/api/cart` | POST | Add items to the cart |
| `/api/orders` | POST | Place an order |

## Contribution Guidelines
We welcome contributions! Feel free to submit issues, feature requests, or pull requests to improve this project.

## License
This project is open-source and available under the MIT License.

## Contact
For any queries or collaboration, reach out to [Parth Karma](https://github.com/Parthkarma).
