package com.edutrack.controller;

import com.edutrack.model.Batch;
import com.edutrack.model.Student;
import com.edutrack.service.EduTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private EduTrackService service;

    @PostMapping("/admin/batch/add")
    public String addBatch(@ModelAttribute Batch batch) {
        service.saveBatch(batch);
        return "redirect:/admin/manage";
    }

    @GetMapping("/admin/batch/delete/{id}")
    public String deleteBatch(@PathVariable String id) {
        service.deleteBatch(id);
        return "redirect:/admin/manage";
    }

    @PostMapping("/admin/student/add")
    public String addStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/admin/manage";
    }

    @GetMapping("/admin/student/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return "redirect:/admin/manage";
    }
}
