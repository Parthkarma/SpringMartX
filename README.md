# 🛒 SpringMartX - E-Commerce Platform (Backend)  

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)  
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)  
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)  
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)  

---

## 📌 **Overview**  
SpringMartX is a full-stack **e-commerce platform** built with **Spring Boot** for the backend and **React** for the frontend. It provides a seamless shopping experience with features like **product management, user authentication, shopping cart, and order processing.**  

---

## 🔗 **Project Links:**  

🔹 **Backend Repository:** [![Spring Boot](https://img.shields.io/badge/Backend-SpringBoot-green?style=flat&logo=spring)](https://github.com/Parthkarma/SpringMartX)  
🔹 **Frontend Repository:** [![React](https://img.shields.io/badge/Frontend-React-blue?style=flat&logo=react)](https://github.com/Parthkarma/SpringMartxUI)  
🔹 **API Documentation:** [![Postman API](https://img.shields.io/badge/API-Postman-orange?style=flat&logo=postman)](https://documenter.getpostman.com/view/33652413/2sAYX3sPPt)  

---

## 🚀 **Features**  

### **🔧 Backend (Spring Boot - SpringMartX)**
- 🔐 **Authentication & Authorization** – Secure JWT-based login/signup  
- 📂 **Category Management** – CRUD operations on product categories  
- 🛍️ **Product Management** – Add, update, and delete products  
- 🛒 **Cart Functionality** – Add to cart, update, and remove items  
- 🛡️ **Security Features** – Role-based access control  

---

## 🛠 **Tech Stack**  

### **🖥️ Backend:**  
| Technology | Description |
|------------|------------|
| ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white) | Core programming language |
| ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring&logoColor=white) | Backend framework |
| ![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=flat&logo=spring&logoColor=white) | JWT-based authentication |
| ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat&logo=hibernate&logoColor=white) | ORM for database operations |
| ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white) | Relational Database |
| ![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apache-maven&logoColor=white) | Dependency management |
| ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=postman&logoColor=white) | API Testing |

---
## 📂 Project Structure  

```
SpringMartX/  
│── src/  
│   ├── main/java/com/ecommerce/project/  
│   │   ├── **config/**               # Security & Web Configurations  
│   │   ├── **controller/**           # API Controllers  
│   │   │   ├── AuthController.java   # User Authentication  
│   │   │   ├── ProductController.java # Product Operations  
│   │   │   ├── CartController.java   # Shopping Cart  
│   │   │   ├── CategoryController.java # Category Management  
│   │   ├── **exceptions/**           # Custom Exception Handling  
│   │   ├── **model/**                # Database Entities  
│   │   │   ├── User.java             # User Model  
│   │   │   ├── Product.java          # Product Model  
│   │   │   ├── Category.java         # Category Model  
│   │   │   ├── Cart.java             # Cart Model  
│   │   ├── **repositories/**         # Database Repositories  
│   │   ├── **security/**             # Security & JWT Configurations  
│   │   │   ├── WebSecurityConfig.java # Security Setup  
│   │   │   ├── jwt/                  # JWT Utility Classes  
│   │   ├── **service/**              # Business Logic Services  
│   │   ├── **util/**                 # Utility Classes  
│   │   ├── SbEcomApplication.java    # Main Spring Boot Application  
│── src/main/resources/  
│   ├── application.properties        # Database & App Configurations  
│── pom.xml                           # Project Dependencies  
│── README.md                         # Documentation  
```


## ⚙️ **Getting Started**  

### **🖥️ Backend Setup**  
1️⃣ **Clone the Repository**  
```bash
git clone https://github.com/Parthkarma/SpringMartX.git
cd SpringMartX
Run the application : 
mvn spring-boot:run
