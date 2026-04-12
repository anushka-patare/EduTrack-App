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
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Clear and recreate users to ensure login always works with default credentials for demo
        userRepository.deleteAll();
        
        // Initial Admin user
        User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN");
        userRepository.save(admin);
        
        // Initial Student user
        User student = new User("student", passwordEncoder.encode("student123"), "STUDENT");
        userRepository.save(student);
        
        System.out.println("--------------------------------------------------");
        System.out.println("VIVA DEMO CREDENTIALS:");
        System.out.println("Admin Login: admin / admin123");
        System.out.println("Student Login: student / student123");
        System.out.println("--------------------------------------------------");
    }
}
