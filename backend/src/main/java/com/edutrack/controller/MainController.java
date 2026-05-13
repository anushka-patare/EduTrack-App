package com.edutrack.controller;

import com.edutrack.model.*;
import com.edutrack.service.EduTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    private EduTrackService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("batches", service.getAllBatches());
        model.addAttribute("placements", service.getAllPlacements().stream().filter(p -> !p.isHidden()).collect(Collectors.toList()));
        model.addAttribute("reviews", service.getAllReviews().stream().filter(r -> "APPROVED".equals(r.getStatus())).collect(Collectors.toList()));
        model.addAttribute("gallery", service.getAllGalleryImages().stream().filter(g -> !g.isHidden()).collect(Collectors.toList()));
        model.addAttribute("settings", service.getSiteSettings());
        model.addAttribute("newContact", new ContactMessage());
        model.addAttribute("newReview", new Review());
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("settings", service.getSiteSettings());
        return "about";
    }

    @PostMapping("/contact/submit")
    public String submitContact(@ModelAttribute ContactMessage contact) {
        contact.setSubmittedAt(java.time.LocalDateTime.now());
        service.saveContactMessage(contact);
        return "redirect:/?contactSuccess=true#contact";
    }

    @PostMapping("/review/submit")
    public String submitReview(@ModelAttribute Review review, @RequestParam(value = "profileImage", required = false) MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                String base64 = java.util.Base64.getEncoder().encodeToString(file.getBytes());
                review.setProfileImageBase64("data:" + file.getContentType() + ";base64," + base64);
            }
        } catch (Exception e) {}
        review.setStatus("PENDING");
        review.setDate(java.time.LocalDate.now().toString());
        service.saveReview(review);
        return "redirect:/?reviewSuccess=true#reviews";
    }

    @GetMapping("/batch/{id}")
    public String batchDetails(@PathVariable String id, Model model) {
        Batch batch = service.getAllBatches().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst().orElse(null);
        model.addAttribute("batch", batch);
        model.addAttribute("settings", service.getSiteSettings());
        return "batch-details";
    }

    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        List<Student> students = service.getAllStudents();
        List<Batch> batches = service.getAllBatches();

        double collected = students.stream().mapToDouble(Student::getFeesPaid).sum();
        double pending = students.stream().mapToDouble(Student::getFeesRemaining).sum();

        model.addAttribute("totalStudents", students.size());
        model.addAttribute("totalBatches", batches.size());
        model.addAttribute("collectedFees", collected);
        model.addAttribute("pendingFees", pending);
        model.addAttribute("students", students);
        
        return "admin/dashboard";
    }

    @GetMapping("/admin/manage")
    public String manageRecords(Model model) {
        model.addAttribute("batches", service.getAllBatches());
        model.addAttribute("newBatch", new Batch());
        return "admin/manage";
    }

    @GetMapping("/student")
    public String studentPortal(Model model) {
        model.addAttribute("batches", service.getAllBatches());
        return "student/portal";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
