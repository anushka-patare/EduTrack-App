package com.edutrack.controller;

import com.edutrack.model.Batch;
import com.edutrack.model.Student;
import com.edutrack.service.EduTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EduTrackService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("batches", service.getAllBatches());
        return "index";
    }

    @GetMapping("/batch/{id}")
    public String batchDetails(@PathVariable String id, Model model) {
        Batch batch = service.getAllBatches().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst().orElse(null);
        model.addAttribute("batch", batch);
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
        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("batches", service.getAllBatches());
        model.addAttribute("newStudent", new Student());
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
