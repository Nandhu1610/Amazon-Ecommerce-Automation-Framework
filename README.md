# Amazon-Ecommerce-Automation-Framework

## 📌 Project Overview

This project is a Selenium WebDriver Automation Testing Framework built using Java, TestNG, Maven, and Page Object Model (POM) design pattern.  

It automates key end-to-end user workflows of an e-commerce application Amazon, including registration, login, product search, cart management, and checkout process.

---

## 🛠️ Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Git & GitHub

---

## 🧪 Test Scenarios Covered

The following test cases are automated in this project:

### 🔐 Authentication
1. Verify that a new user can successfully register.
2. Verify login is successful with correct email and password.
3. Ensure login fails with incorrect email or password.

---

### 👤 User Profile
4. Check if a user can successfully edit their profile information.

---

### 🔎 Product Search
5. Verify searching for products using keywords (e.g., "shoe").
6. Validate product search with filters (category, price range) returns accurate results.
7. Ensure product detail page displays correct information (price, reviews, description).
8. Verify sorting functionality (relevance, price, rating, etc.).

---

### 🛒 Cart Functionality
9. Verify that items can be added to the shopping cart from product pages.
10. Test updating quantity and removing items from the cart.

---

### 💳 Checkout Flow
11. Validate complete checkout process including:
   - Address selection
   - Payment method selection
   - Order review

12. Verify all available payment methods can be selected.

---

### 🚫 Negative / Edge Testing
13. Ensure user can navigate to cart page without login (based on application behavior).

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   ├── pages
│
└── test
    ├── java
    │   ├── base
    │   ├── testcases
    │   └── utilities
```

---

## 🚀 How to Run This Project

### Step 1: Clone the repository
```
git clone https://github.com/Nandhu1610/Amazon-Ecommerce-Automation-Framework.git
```

### Step 2: Import project into IDE
- Open as Maven Project (Eclipse / IntelliJ)

### Step 3: Install dependencies
```
mvn clean install
```

### Step 4: Run test suite
- Execute `testng.xml` file

---

## 📊 Key Features

- Page Object Model (POM) design
- Reusable methods and utilities
- Cross-browser testing support
- TestNG test execution
- Modular framework structure

---

## 🎯 Objective

The main objective of this project is to demonstrate:
- End-to-end automation of e-commerce workflows
- Real-world QA Automation framework design
- Strong understanding of Selenium, Java, and TestNG

---

## 👨‍💻 Author

**Nandhini**  
QA Engineer | Manual Testing | Automation Testing (Selenium, Java, TestNG)

GitHub: https://github.com/Nandhu1610
LinkedIn: https://www.linkedin.com/in/nandhini-m-1b55a9128/
