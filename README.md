# 🎓 EduTrack - Advanced Institute Management System

EduTrack is a modern, full-stack management solution designed for educational institutes, coaching centers, and training hubs. Built with **Spring Boot 3**, **MongoDB Atlas**, and **Thymeleaf**, it offers a seamless experience for both administrators and students.

---

## 🌟 Key Features

### 🛠️ Admin Dashboard (The Control Center)
- **Course & Batch Management:** Create and manage course durations, fees, and detailed syllabi.
- **Student Registrations:** Dedicated view for tracking student profiles, financial status, and contact info.
- **Account Approval System:** New student registrations remain pending until verified and approved by an admin.
- **Academics Management:**
  - Send **Broadcast Notifications** to specific batches or the entire institute.
- **Public Site Management:** Update the "About Us" section, manage the **Gallery**, moderate **Student Reviews**, and track **Placements**.

### 👨‍🎓 Student Portal (Self-Service Hub)
- **Smart Dashboard:** View recent notifications and quick stats on your enrollment.
- **Financial Tracking:** Real-time view of fees paid vs. fees remaining with digital receipt access.
- **Profile Management:** Students can update their own profile photo, mobile number, and password.
- **Account Security:** Automatic password generation (using mobile number) for new registrations.
- **Online Courses:** Browse and purchase additional courses directly from the portal.

---

## 🔐 Login Credentials (Demo Mode)

| Role | Username / Email | Password | Access Route |
| :--- | :--- | :--- | :--- |
| **Admin** | `admin` | `admin123` | `/login` |
| **Student** | `student` | `student123` | `/student/login` |

---

## 🚀 Getting Started Locally

### 1. Prerequisites
- **Java 17** or higher.
- **Maven 3.6+** installed.
- **MongoDB Atlas** account (or local MongoDB).

### 2. Configuration
Update `backend/src/main/resources/application.properties` with your MongoDB URI:
```properties
spring.data.mongodb.uri=your_mongodb_connection_string
```

### 3. Build & Run
```cmd
cd backend
mvn clean spring-boot:run
```
The app will be available at [http://localhost:8080](http://localhost:8080)

---



## 🏗️ Tech Stack
- **Backend:** Java 17, Spring Boot 3.2.4
- **Security:** Spring Security (Role-based access)
- **Database:** MongoDB Atlas (Cloud)
- **Frontend:** Thymeleaf, Bootstrap 5, Vanilla JS
- **Deployment:** Docker, Render.com

---
*Developed by Antigravity A*