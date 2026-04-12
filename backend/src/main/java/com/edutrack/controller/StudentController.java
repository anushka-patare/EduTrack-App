package com.edutrack.controller;

import com.edutrack.model.Batch;
import com.edutrack.model.Student;
import com.edutrack.service.EduTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    private EduTrackService service;

    @PostMapping("/student/register")
    public String registerStudent(@RequestParam String name, 
                                  @RequestParam String email, 
                                  @RequestParam String gender,
                                  @RequestParam String batch) {
        Batch b = service.getAllBatches().stream()
                .filter(it -> it.getName().equals(batch))
                .findFirst().orElse(null);
        
        double totalFees = (b != null) ? b.getTotalFees() : 0;
        
        Student student = new Student(name, email, gender, batch, 0, totalFees);
        service.saveStudent(student);
        return "redirect:/student?registered=true";
    }

    @GetMapping("/student/status")
    public String checkStatus(@RequestParam String email, Model model) {
        Student s = service.getAllStudents().stream()
                .filter(st -> st.getEmail().equalsIgnoreCase(email))
                .findFirst().orElse(null);
        
        model.addAttribute("student", s);
        model.addAttribute("batches", service.getAllBatches());
        return "student/portal";
    }
}
