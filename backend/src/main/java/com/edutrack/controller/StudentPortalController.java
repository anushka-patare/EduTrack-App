package com.edutrack.controller;

import com.edutrack.model.*;
import com.edutrack.service.EduTrackService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;
import java.time.LocalDate;

@Controller
@RequestMapping("/student")
public class StudentPortalController {

    @Autowired
    private EduTrackService service;

    // Authentication
    @GetMapping("/login")
    public String loginPage() {
        return "student/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("batches", service.getAllBatches());
        return "student/register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute Student student) {
        student.setJoiningDate(LocalDate.now().toString());
        student.setApproved(false); // Wait for admin approval if needed, or set true
        // For new registration, remaining fees will be assigned by admin
        // Or calculate based on selected batch
        Batch batch = service.getAllBatches().stream().filter(b -> b.getName().equals(student.getBatch())).findFirst().orElse(null);
        if (batch != null) {
            student.setFeesRemaining(batch.getTotalFees());
            student.setFeesPaid(0);
        }
        service.saveStudent(student);
        return "redirect:/student/login?registered=true";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Student s = service.authenticateStudent(email, password);
        if (s != null) {
            session.setAttribute("loggedInStudent", s);
            return "redirect:/student/dashboard";
        }
        model.addAttribute("error", "Invalid email or password");
        return "student/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/student/login";
    }

    // Auth Filter Method
    private Student getCurrentStudent(HttpSession session) {
        return (Student) session.getAttribute("loggedInStudent");
    }

    // Dashboard
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Student student = getCurrentStudent(session);
        if (student == null) return "redirect:/student/login";
        
        // Refresh student data from DB
        student = service.getStudentById(student.getId());
        session.setAttribute("loggedInStudent", student);
        
        model.addAttribute("student", student);
        model.addAttribute("notifications", service.getNotifications(student.getBatch()));
        
        return "student/dashboard";
    }

    // Profile
    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        Student student = getCurrentStudent(session);
        if (student == null) return "redirect:/student/login";
        model.addAttribute("student", student);
        return "student/profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute Student updatedData, @RequestParam(value = "photo", required = false) MultipartFile photo, HttpSession session) {
        Student student = getCurrentStudent(session);
        if (student == null) return "redirect:/student/login";

        student = service.getStudentById(student.getId());
        student.setMobile(updatedData.getMobile());
        student.setAddress(updatedData.getAddress());
        if(updatedData.getPassword() != null && !updatedData.getPassword().isEmpty()){
            student.setPassword(updatedData.getPassword());
        }

        try {
            if (photo != null && !photo.isEmpty()) {
                student.setProfilePhotoBase64("data:" + photo.getContentType() + ";base64," + Base64.getEncoder().encodeToString(photo.getBytes()));
            }
        } catch (Exception e) {}

        service.saveStudent(student);
        session.setAttribute("loggedInStudent", student);
        return "redirect:/student/profile?success=true";
    }

    // Online Courses
    @GetMapping("/online-courses")
    public String onlineCourses(HttpSession session, Model model) {
        Student student = getCurrentStudent(session);
        if (student == null) return "redirect:/student/login";
        
        model.addAttribute("courses", service.getAllBatches());
        model.addAttribute("student", student);
        return "student/online-courses";
    }

    // Payments
    @GetMapping("/payments")
    public String payments(HttpSession session, Model model) {
        Student student = getCurrentStudent(session);
        if (student == null) return "redirect:/student/login";
        
        model.addAttribute("student", student);
        model.addAttribute("payments", service.getPaymentRecords(student.getId()));
        
        Batch batch = service.getAllBatches().stream().filter(b -> b.getName().equals(student.getBatch())).findFirst().orElse(null);
        model.addAttribute("batch", batch);
        
        return "student/payments";
    }

    @GetMapping("/pay/{batchId}")
    public String payPage(@PathVariable String batchId, HttpSession session, Model model) {
        Student student = getCurrentStudent(session);
        if (student == null) return "redirect:/student/login";
        
        Batch batch = service.getAllBatches().stream().filter(b -> b.getId().equals(batchId)).findFirst().orElse(null);
        if (batch == null) return "redirect:/student/dashboard";
        
        model.addAttribute("student", student);
        model.addAttribute("batch", batch);
        return "student/pay";
    }

    @PostMapping("/pay/process")
    public String processPayment(@RequestParam String batchId, @RequestParam double amount, HttpSession session) {
        Student student = getCurrentStudent(session);
        if (student == null) return "redirect:/student/login";
        
        student = service.getStudentById(student.getId());
        
        // Update batch if they are enrolling in a new one, else just add fees
        Batch batch = service.getAllBatches().stream().filter(b -> b.getId().equals(batchId)).findFirst().orElse(null);
        if (batch != null && !batch.getName().equals(student.getBatch())) {
            student.setBatch(batch.getName());
            student.setFeesRemaining(batch.getTotalFees());
            student.setFeesPaid(0);
        }
        
        student.setFeesPaid(student.getFeesPaid() + amount);
        student.setFeesRemaining(Math.max(0, student.getFeesRemaining() - amount));
        service.saveStudent(student);
        
        PaymentRecord pr = new PaymentRecord();
        pr.setStudentId(student.getId());
        pr.setAmount(amount);
        pr.setDate(LocalDate.now().toString());
        service.savePaymentRecord(pr);
        
        session.setAttribute("loggedInStudent", student);
        return "redirect:/student/payments?paymentSuccess=true";
    }
}
