# 🏦 Bank Management System

A professional, secure, and scalable Bank Management System built with Spring Boot.  
_This is a pet project designed for learning and demonstrating best practices in modern Java web application development._

---

## 🌟 Overview

The **Bank Management System** is a full-featured backend application that manages banking operations, user authentication, and data storage. This project leverages industry-standard libraries and design patterns to ensure maintainability, security, and scalability.

---

## 🔐 Security

- **Spring Security**: Provides robust authentication and authorization.
- **JWT (JSON Web Tokens)**: Implements stateless, token-based user authentication for secure API access.

---

## 🏗️ Architecture & Design Patterns

- **Controller-Service-Repository Pattern**: Clean separation of concerns for maintainable code.
- **DTO (Data Transfer Object)**: Used to transfer data efficiently and securely between layers.
- **Hibernate ORM**: Handles database interactions and object-relational mapping.

---

## 🚀 Features

- **User Authentication & Authorization** (JWT + Spring Security)
- **Account Management**: Create, retrieve, update, and delete bank accounts
- **Transaction Management**: Deposit, withdrawal, and transfer operations
- **Customer Management**: Manage customer information and profiles
- **Role-based Access**: Different roles for admin and customers
- **RESTful API Endpoints**: Clean and well-documented endpoints

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot, Spring Security, JWT, Hibernate (JPA)
- **Database**: PostgreSQL
- **Build Tool**: Maven/Gradle
- **Language**: Java

---

## 🏁 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/jianbot007/BankMGT.git
cd BankMGT
```

### 2. Configure the Database

- By default, the project uses an in-memory H2 database for development.
- To use MySQL or PostgreSQL, update the `application.properties` file with your database connection details.

### 3. Run the Application

```bash
./mvnw spring-boot:run
```
_or_
```bash
./gradlew bootRun
```

### 4. Access the API

- API will be available at: `http://localhost:8080/`
- Use tools like Postman to test authentication and endpoints.

---

## 📁 Project Structure

```
src/
 └── main/
     ├── java/
     │    └── controller/
     │    └── service/
     │    └── repository/
     │    └── dto/
     │    └── model/
     ├── resources/
     │    └── application.properties
```

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!<br>
Please fork the repository and create a pull request.

---

## 📜 License

Currently, this project does not specify a license.

---

> **Repository:** [jianbot007/BankMGT](https://github.com/jianbot007/BankMGT)  
> _Developed as a pet project by [jianbot007](https://github.com/jianbot007)_
