package com.edutrack.service;

import com.edutrack.model.Batch;
import com.edutrack.model.User;
import com.edutrack.model.GalleryImage;
import com.edutrack.model.Placement;
import com.edutrack.model.Review;
import com.edutrack.repository.BatchRepository;
import com.edutrack.repository.UserRepository;
import com.edutrack.repository.GalleryImageRepository;
import com.edutrack.repository.PlacementRepository;
import com.edutrack.repository.ReviewRepository;
import com.edutrack.repository.SiteSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BatchRepository batchRepository;
    
    @Autowired
    private GalleryImageRepository galleryImageRepository;

    @Autowired
    private PlacementRepository placementRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private SiteSettingsRepository siteSettingsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Only seed data if no users exist (prevent data loss on restart)
        if (userRepository.count() == 0) {
            // Initial Admin user
            User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN");
            userRepository.save(admin);
            
            // Initial Student user
            User student = new User("student", passwordEncoder.encode("student123"), "STUDENT");
            userRepository.save(student);
        }

        // Only seed batches if empty
        if (batchRepository.count() == 0) {
            String pythonSyllabus = "1) Python Programming Basics\n" +
                               "2) Advanced Python\n" +
                               "3) Object-Oriented Programming (OOP)\n" +
                               "4) File Handling & Exception Handling\n" +
                               "5) Web Frameworks: Django & Flask\n" +
                               "6) Frontend: HTML, CSS, JavaScript\n" +
                               "7) Database Integration with PostgreSQL/MongoDB\n" +
                               "8) Real-world Projects & Deployment";

        Batch pythonBatch = new Batch(
            "Python Full Stack Development",
            "6 Months",
            49999.97,
            "Complete Python Full Stack course covering backend development with Django/Flask, frontend technologies, and real-world project building.",
            pythonSyllabus,
            LocalDate.now(),
            LocalDate.now().plusMonths(6)
        );
        batchRepository.save(pythonBatch);

        String javaSyllabus = "1) Core Java Fundamentals\n" +
                             "2) Advanced Java & JSP/Servlets\n" +
                             "3) Spring Boot & Microservices\n" +
                             "4) Hibernate & Spring Data JPA\n" +
                             "5) Spring Security & JWT\n" +
                             "6) REST API Development\n" +
                             "7) Frontend Integration with React\n" +
                             "8) Modern DevOps with Docker & Jenkins";

        Batch javaBatch = new Batch(
            "Java Full Stack Development",
            "6 Months",
            54999.00,
            "Master Java development from scratch to advanced microservices architecture with Spring Boot and modern frontend frameworks.",
            javaSyllabus,
            LocalDate.now(),
            LocalDate.now().plusMonths(6)
        );
        batchRepository.save(javaBatch);

        // Additional Courses
        String reactSyllabus = "1) HTML5 & CSS3 Masterclass\n2) JavaScript Fundamentals (ES6+)\n3) React Basics & Components\n4) State Management with Redux/Context\n5) Hooks & Performance Optimization\n6) Integration with REST APIs\n7) Testing with Jest & RTL\n8) Real-world Portfolio Projects";
        Batch reactBatch = new Batch(
            "ReactJS & Frontend Development",
            "3 Months",
            29999.00,
            "Build dynamic and responsive user interfaces with the most popular frontend library ReactJS.",
            reactSyllabus,
            LocalDate.now(),
            LocalDate.now().plusMonths(3)
        );
        batchRepository.save(reactBatch);

        String dsSyllabus = "1) Python for Data Science\n2) Statistics & Probability\n3) Data Visualization (Matplotlib, Seaborn)\n4) Machine Learning Algorithms\n5) Deep Learning with TensorFlow\n6) Natural Language Processing (NLP)\n7) Computer Vision Basics\n8) Capstone Projects & Kaggle Competitions";
        Batch dsBatch = new Batch(
            "Data Science & Machine Learning",
            "8 Months",
            64999.00,
            "Deep dive into the world of data and AI. Learn to build predictive models and analyze complex datasets.",
            dsSyllabus,
            LocalDate.now(),
            LocalDate.now().plusMonths(8)
        );
        batchRepository.save(dsBatch);

        String uiuxSyllabus = "1) Introduction to Design Thinking\n2) User Research & Personas\n3) Information Architecture\n4) Wireframing & Prototyping\n5) Visual Design Principles\n6) Figma & Adobe XD Mastery\n7) Usability Testing\n8) Building a Professional Portfolio";
        Batch uiuxBatch = new Batch(
            "UI/UX Design & Figma",
            "4 Months",
            34999.00,
            "Craft beautiful and user-centric designs. Master the art of creating seamless digital experiences.",
            uiuxSyllabus,
            LocalDate.now(),
            LocalDate.now().plusMonths(4)
        );
        batchRepository.save(uiuxBatch);

        String cloudSyllabus = "1) Cloud Fundamentals & Types\n2) AWS Core Services (EC2, S3, RDS)\n3) Identity & Access Management (IAM)\n4) VPC & Networking in Cloud\n5) Serverless Architecture (Lambda)\n6) Cloud Security Best Practices\n7) DevOps Basics in AWS\n8) Multi-region Deployment Strategies";
        Batch cloudBatch = new Batch(
            "Cloud Computing & AWS",
            "5 Months",
            44999.00,
            "Scale your career with Cloud Computing. Master AWS services and learn to manage production workloads.",
            cloudSyllabus,
            LocalDate.now(),
            LocalDate.now().plusMonths(5)
        );
        batchRepository.save(cloudBatch);
        }
        
        // Initialize Gallery Images
        if (galleryImageRepository.count() == 0) {
        
        GalleryImage img1 = new GalleryImage();
        img1.setTitle("Classroom Setup");
        img1.setImageBase64("https://images.unsplash.com/photo-1524178232363-1fb2b075b655?q=80&w=2070&auto=format&fit=crop");
        img1.setHidden(false);
        galleryImageRepository.save(img1);
        
        GalleryImage img2 = new GalleryImage();
        img2.setTitle("Our Students at Hackathon");
        img2.setImageBase64("https://images.unsplash.com/photo-1515162816999-a0c47dc192f7?q=80&w=2070&auto=format&fit=crop");
        img2.setHidden(false);
        galleryImageRepository.save(img2);
        
        GalleryImage img3 = new GalleryImage();
        img3.setTitle("Graduation Day");
        img3.setImageBase64("https://images.unsplash.com/photo-1523050854058-8df90110c9f1?q=80&w=2070&auto=format&fit=crop");
        img3.setHidden(false);
        galleryImageRepository.save(img3);
        
        GalleryImage img4 = new GalleryImage();
        img4.setTitle("Computer Lab");
        img4.setImageBase64("https://images.unsplash.com/photo-1517694712202-14dd9538aa97?q=80&w=2070&auto=format&fit=crop");
        img4.setHidden(false);
        galleryImageRepository.save(img4);

        GalleryImage img5 = new GalleryImage();
        img5.setTitle("Tech Seminar");
        img5.setImageBase64("https://images.unsplash.com/photo-1540575467063-178a50c2df87?q=80&w=2070&auto=format&fit=crop");
        img5.setHidden(false);
        galleryImageRepository.save(img5);

        GalleryImage img6 = new GalleryImage();
        img6.setTitle("Campus Tour");
        img6.setImageBase64("https://images.unsplash.com/photo-1562774053-701939374585?q=80&w=2086&auto=format&fit=crop");
        img6.setHidden(false);
        galleryImageRepository.save(img6);
        }

        // Initialize Placements
        if (placementRepository.count() == 0) {

        Placement p1 = new Placement();
        p1.setCompanyName("Google");
        p1.setStudentName("Rahul Sharma");
        p1.setPackageSalary("24 LPA");
        p1.setTechnology("Java Full Stack");
        p1.setPlacementDate(LocalDate.now().toString());
        p1.setSuccessStory("Got placed after rigorous training at EduTrack.");
        p1.setHidden(false);
        placementRepository.save(p1);

        Placement p2 = new Placement();
        p2.setCompanyName("Microsoft");
        p2.setStudentName("Priya Patel");
        p2.setPackageSalary("28 LPA");
        p2.setTechnology("Python & AI");
        p2.setPlacementDate(LocalDate.now().toString());
        p2.setSuccessStory("EduTrack's mock interviews really helped.");
        p2.setHidden(false);
        placementRepository.save(p2);

        Placement p3 = new Placement();
        p3.setCompanyName("Amazon");
        p3.setStudentName("Amit Kumar");
        p3.setPackageSalary("20 LPA");
        p3.setTechnology("Cloud & DevOps");
        p3.setPlacementDate(LocalDate.now().toString());
        p3.setSuccessStory("Excellent guidance from mentors.");
        p3.setHidden(false);
        placementRepository.save(p3);

        Placement p4 = new Placement();
        p4.setCompanyName("TCS Digital");
        p4.setStudentName("Sneha Desai");
        p4.setPackageSalary("12 LPA");
        p4.setTechnology("Java Spring Boot");
        p4.setPlacementDate(LocalDate.now().toString());
        p4.setSuccessStory("Highly recommend EduTrack to everyone.");
        p4.setHidden(false);
        placementRepository.save(p4);
        }

        // Initialize Reviews
        if (reviewRepository.count() == 0) {

        Review r1 = new Review();
        r1.setStudentName("Vikram Singh");
        r1.setCourse("Java Full Stack");
        r1.setRating(5);
        r1.setMessage("The best place to learn coding from scratch. The trainers are highly experienced.");
        r1.setDate(LocalDate.now().toString());
        r1.setStatus("APPROVED");
        reviewRepository.save(r1);

        Review r2 = new Review();
        r2.setStudentName("Anjali Mehta");
        r2.setCourse("Python & Django");
        r2.setRating(4);
        r2.setMessage("Great curriculum and excellent placement support. Only wish the batches were smaller.");
        r2.setDate(LocalDate.now().toString());
        r2.setStatus("APPROVED");
        reviewRepository.save(r2);

        Review r3 = new Review();
        r3.setStudentName("Rohan Joshi");
        r3.setCourse("ReactJS Mastery");
        r3.setRating(5);
        r3.setMessage("I got placed in a top MNC within a month of completing the course!");
        r3.setDate(LocalDate.now().toString());
        r3.setStatus("APPROVED");
        reviewRepository.save(r3);

        Review r4 = new Review();
        r4.setStudentName("Neha Gupta");
        r4.setCourse("Data Science");
        r4.setRating(5);
        r4.setMessage("Practical assignments and real-world projects helped me understand the concepts deeply.");
        r4.setDate(LocalDate.now().toString());
        r4.setStatus("APPROVED");
        reviewRepository.save(r4);

        Review r5 = new Review();
        r5.setStudentName("Karan Kapoor");
        r5.setCourse("Java Full Stack");
        r5.setRating(5);
        r5.setMessage("Extremely supportive staff and amazing learning environment.");
        r5.setDate(LocalDate.now().toString());
        r5.setStatus("APPROVED");
        reviewRepository.save(r5);
        }

        // Initialize Site Settings
        if (siteSettingsRepository.count() == 0) {
            com.edutrack.model.SiteSettings settings = new com.edutrack.model.SiteSettings();
            settings.setId("global");
            settings.setInstituteIntro("Welcome On EduTrack");
            settings.setVisionMission("Vision To become a leading technology training institute that empowers students with technical skills, innovation, and career opportunities.");
            settings.setWhyChooseUs("Industry Experts, Real-world Projects, 100% Placement Support.");
            settings.setMobileNumber("+91 8767363217");
            settings.setEmail("contact@edutrack.com");
            settings.setAddress("Pune, Maharashtra");
            settings.setFacebookUrl("https://facebook.com");
            settings.setInstagramUrl("https://instagram.com");
            settings.setLinkedinUrl("https://linkedin.com");
            settings.setStudentStats(5000);
            settings.setPlacementStats(1200);
            siteSettingsRepository.save(settings);
        }
        
        System.out.println("--------------------------------------------------");
        System.out.println("VIVA DEMO CREDENTIALS:");
        System.out.println("Admin Login: admin / admin123");
        System.out.println("Student Login: student / student123");
        System.out.println("Data Seeding: Batches and Users initialized successfully.");
        System.out.println("--------------------------------------------------");
    }
}
