# BankMGT - Bank Management System

This is a backend project built using Spring Boot for learning purpose. It simulates basic banking operations such as user registration, transactions, and admin-level operations.
*User can login,register,withdraw,transfer,deposit money.
*Admin can restrict a user.Restrict user cant do any transactions.

## 🛠 Technologies Used

- Java 21
- Spring Boot 3.4.5
- Maven
- REST APIs

## 🚀 How to Run the Project

1. **Clone or Download the Project**
   ```
   git clone the repo
   ```
   Or simply unzip the folder if you downloaded the ZIP file.

2. **Open the Project in an IDE**
   - Use IntelliJ IDEA, Eclipse, or any Java IDE.
   - Import it as a **Maven** project.

3. **Build the Project**
   In the terminal, navigate to the project folder and run:
   ```
   ./mvnw clean install
   ```

4. **Run the Application**
   ```
   ./mvnw spring-boot:run
   ```

   The backend will start at:  
   ```
   http://localhost:8080
   ```

## 📮 How to Test with Postman

### 1. Test if Server is Running
- Method: `GET`  
- URL: `http://localhost:8080/test`

### 2. Register a New User
- Method: `POST`  
- URL: `http://localhost:8080/register`  
- Body (JSON):
   ```json
   {
     "name": "John Doe",
     "email": "john@example.com",
     "password": "password123"
   }
   ```

### 3. Perform a Transaction
- Method: `POST`  
- URL: `http://localhost:8080/transaction`  
- Body (JSON):
   ```json
   {
     "fromAccount": "123456",
     "toAccount": "654321",
     "amount": 1000
   }
   ```

### 4. Admin Actions (Example)
- Method: `GET`  
- URL: `http://localhost:8080/admin/users`

> (*Update URLs based on your actual controller mappings if needed.*)

## 📁 Project Structure

```
BankMGT/
├── src/
│   └── main/
│       └── java/com/BankMGT/BankMGT/
│           ├── Controller/
│           │   ├── AdminController.java
│           │   ├── RegistrationController.java
│           │   └── TransactionController.java
│           └── TestController.java
├── pom.xml
```

## 📝 Notes

- Use **Postman** to test the APIs.
- Update `application.properties` if you want to configure port or database settings.
