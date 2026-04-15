# 📘 EduTrack – Advanced Institute Management System (Cloud Edition)

EduTrack is a modern, high-performance web application designed for educational institutes. It manages **Students, Batches, and Fees** using a professional dashboard interface. The project is built **entirely in Java**, utilizing **Spring Boot** and **Thymeleaf with Bootstrap 5**, ensuring no manual HTML/JS files are required.

---

## 🎯 Key Modules & Features

### 👨💼 1. Admin Module
The central hub for administrators with full authority.
- **Executive Dashboard**: View real-time statistics (Total Students, Batches, Collected Fees, Pending Fees).
- **Batch Management**: Create and manage academic batches with custom pricing and duration.
- **Student Management**: Full CRUD operations to add, update, or remove students and assign them to batches.
- **Financial Tracking**: Track every rupee with specific "Paid" vs "Remaining" fee records.

### 👨🎓 2. Student Portal
A user-friendly area for current and prospective students.
- **Self-Enrollment**: Register into the system and select a desired course batch.
- **Course Catalog**: Browse all available batches and their respective fee structures.
- **Self-Service Status**: Search by email to check registration details, batch assignment, and payment status.

---

## 🔐 Login Credentials (VIVA / Demo Mode)

For ease of demonstration during Viva, the system automatically resets credentials on every startup:

| Role | Username | Password | Access Route |
| :--- | :--- | :--- | :--- |
| **Admin** | `admin` | `admin123` | `/login` |
| **Student** | `student` | `student123` | `/student` (Status Check) |

---

## 🚀 How to Run the Project (Step-by-Step)

### 1. Prerequisites
- **Java 17** or higher.
- **Maven 3.6+** installed.
- **Port 8080** must be free.

### 2. Kill Existing Processes (If Port 8080 is Erroring)
If you get a "Port 8080 already in use" error, run this in CMD:
```cmd
netstat -ano | findstr :8080
taskkill /F /PID <PID_NUMBER_FROM_FIRST_COMMAND>
```

### 3. Build & Run
1. Open Command Prompt (CMD).
2. Navigate to the `backend` folder:
   ```cmd
   cd e:\java\EduTrack\backend
   ```
3. Run the application:
   ```cmd
   mvn clean spring-boot:run
   ```
4. Once the console shows `Started EduTrackApplication`, open your browser.

### 4. Access URLs
- **Main Home Page**: [http://localhost:8080](http://localhost:8080)
- **Admin Dashboard**: [http://localhost:8080/admin](http://localhost:8080/admin) (Requires Login)
- **Student Portal**: [http://localhost:8080/student](http://localhost:8080/student)

---

## 🏗️ Technical Architecture
- **Backend**: Spring Boot 3.2.4 (Java)
- **UI**: Thymeleaf + Bootstrap 5 (Responsive Dashboard)
- **Database**: MongoDB Atlas (Cloud Storage)
- **Security**: Spring Security (Role-Based Access)

---

## ☁️ Deployment
1. **Package**: `mvn clean package`
2. **Deploy**: Upload `target/edutrack-1.0.0.jar` to Render/AWS.
3. **Database**: The connection string is pre-configured for MongoDB Atlas cloud.

---

## 📚 Detailed Syllabus

Our comprehensive curriculum covers everything from core fundamentals to advanced deployment:

-   **☕ Core Java Fundamentals**: Syntax, Data Types, and Logic.
-   **🏗️ Object-Oriented Programming (OOP)**: Classes, Objects, Inheritance, Polymorphism, Abstraction, and Encapsulation.
-   **⚠️ Exception Handling**: Try-catch blocks, Custom exceptions, and error management.
-   **📦 Collections Framework**: List, Set, Map, and Stream API.
-   **🧵 Multithreading**: Concurrent programming and thread management.
-   **🔌 JDBC (Database Connectivity)**: Connecting Java with relational databases.
-   **🗄️ SQL & Database Design**: Schema design, normalization, and complex queries.
-   **🌐 Servlets & JSP**: Server-side web development basics.
-   **🍃 Spring Ecosystem**:
    -   **Spring Core**: Dependency Injection and IOC.
    -   **Spring Boot**: Auto-configuration and rapid development.
    -   **Spring MVC**: Web architecture.
-   **🚀 REST API Development**: Building scalable web services.
-   **💾 Hibernate / JPA**: Object-Relational Mapping (ORM).
-   **🏗️ Microservices Basics**: Distributed systems and service discovery.
-   **🎨 Frontend Basics**: HTML5, CSS3, and JavaScript (Vanilla).
-   **⚡ Advanced JavaScript (ES6+)**: Modern JS syntax and features.
-   **⚛️ React.js / Angular Basics**: Modern frontend frameworks.
-   **📂 Version Control**: Mastering Git & GitHub.
-   **🛠️ Project Development**: Building end-to-end real-world applications.
-   **☁️ Deployment**: Hosting on AWS, Netlify, and Render.
-   **🎓 Interview Preparation**: Mock interviews, coding challenges, and HR prep.
-   **🧪 Unit Testing**: JUnit and Mockito fundamentals.

---

## ⚙️ Environment Variables

To run this application in a production environment (like Render or Docker), set the following environment variables:

| Variable | Description | Default Value |
|----------|-------------|---------------|
| `MONGODB_URI` | MongoDB Connection String | `mongodb+srv://<user>:<password>@cluster.mongodb.net/edutrack` |
| `PORT` | Application Port | `8080` |

### Setting variables on Cloud (e.g. Render):
1. Go to your Dashboard and navigate to **Environment Variables**.
2. Add a new variable with Key: `MONGODB_URI` and Value: `your_mongodb_connection_string`.
3. Add `PORT` if your hosting requires a specific port.