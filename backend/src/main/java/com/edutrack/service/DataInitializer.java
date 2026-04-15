package com.edutrack.service;

import com.edutrack.model.User;
import com.edutrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private com.edutrack.repository.BatchRepository batchRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        try {
            // Clear and recreate users and batches for demo reset
            userRepository.deleteAll();
            batchRepository.deleteAll();
            
            // Create Sample Batch with the PERFECT, CLEANED Syllabus
            String cleanSyllabus = 
                    "☕ Core Java Fundamentals\n" +
                    "🏗️ Object-Oriented Programming (OOP)\n" +
                    "⚠️ Exception Handling\n" +
                    "📦 Collections Framework\n" +
                    "🧵 Multithreading\n" +
                    "🔌 JDBC (Database Connectivity)\n" +
                    "🗄️ SQL and Database Design\n" +
                    "🌐 Servlets and JSP\n" +
                    "🍃 Spring Core Framework\n" +
                    "🚀 Spring Boot 3.x\n" +
                    "📊 Spring MVC Architecture\n" +
                    "⚡ REST API Development\n" +
                    "💾 Hibernate / JPA (ORM)\n" +
                    "🏗️ Microservices Basics\n" +
                    "🎨 Frontend: HTML, CSS, JavaScript\n" +
                    "💻 Advanced JavaScript (ES6+)\n" +
                    "⚛️ React.js / Angular Basics\n" +
                    "📂 Version Control (Git & GitHub)\n" +
                    "🛠️ End-to-End Project Development\n" +
                    "☁️ Cloud Deployment (AWS / Netlify)\n" +
                    "🎓 Interview Preparation Kit\n" +
                    "🧪 Unit Testing (JUnit/Mockito)";

            com.edutrack.model.Batch javaBatch = new com.edutrack.model.Batch(
                "Java Full Stack Masterclass", 
                "6 Months", 
                25000.0, 
                "A complete industrial training program designed to take you from basics to professional cloud deployment.",
                cleanSyllabus,
                java.time.LocalDate.now(),
                java.time.LocalDate.now().plusMonths(6)
            );
            batchRepository.save(javaBatch);

            // Create Sample Batch for Python Full Stack
            String pythonSyllabus = 
                    "1) Python Programming Basics\n" +
                    "2) Advanced Python (Iterators, Decorators, Generators)\n" +
                    "3) Object-Oriented Programming (OOP) in Python\n" +
                    "4) File Handling & Exception Handling\n" +
                    "5) Database Integration (PostgreSQL/MongoDB)\n" +
                    "6) Web Backend: Django and Flask Frameworks\n" +
                    "7) REST API Development with Django REST Framework\n" +
                    "8) Frontend: HTML5, CSS3, JavaScript, Bootstrap\n" +
                    "9) Deployment & Real-world Project Building";

            com.edutrack.model.Batch pythonBatch = new com.edutrack.model.Batch(
                "Python Full Stack Course", 
                "4 Months", 
                49999.97, 
                "Complete Python Full Stack course covering backend development with Django/Flask, frontend technologies, and real-world project building.",
                pythonSyllabus,
                java.time.LocalDate.now(),
                java.time.LocalDate.now().plusMonths(4)
            );
            batchRepository.save(pythonBatch);

            // Initial Admin user
            User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN");
            userRepository.save(admin);
            
            // Initial Student user
            User student = new User("student", passwordEncoder.encode("student123"), "STUDENT");
            userRepository.save(student);
            
            System.out.println("--------------------------------------------------");
            System.out.println("VIVA DEMO CREDENTIALS (CONNECTED TO MONGODB):");
            System.out.println("Admin Login: admin / admin123");
            System.out.println("Student Login: student / student123");
            System.out.println("--------------------------------------------------");
        } catch (Exception e) {
            System.err.println("==================================================");
            System.err.println("⚠️ WARNING: MONGODB CONNECTION FAILED");
            System.err.println("The application started, but could not connect to Atlas.");
            System.err.println("Please check: 1. IP Whitelist, 2. Internet Connection, 3. Credentials.");
            System.err.println("Error: " + e.getMessage());
            System.err.println("==================================================");
        }
    }
}
