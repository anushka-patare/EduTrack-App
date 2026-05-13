package com.edutrack.controller;

import com.edutrack.model.*;
import com.edutrack.service.EduTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EduTrackService service;

    // Batches
    @PostMapping("/batch/add")
    public String addBatch(@ModelAttribute Batch batch) {
        service.saveBatch(batch);
        return "redirect:/admin/manage";
    }

    @GetMapping("/batch/delete/{id}")
    public String deleteBatch(@PathVariable String id) {
        service.deleteBatch(id);
        return "redirect:/admin/manage";
    }

    // Students
    @GetMapping("/students")
    public String manageStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("newStudent", new Student());
        model.addAttribute("batches", service.getAllBatches());
        return "admin/students";
    }

    @PostMapping("/student/add")
    public String addStudent(@ModelAttribute Student student) {
        // Automatically set password to mobile number for first-time login
        if (student.getMobile() != null && !student.getMobile().isEmpty()) {
            student.setPassword(student.getMobile());
        }
        student.setApproved(true);
        service.saveStudent(student);
        return "redirect:/admin/students";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return "redirect:/admin/students";
    }

    @GetMapping("/student/approve/{id}")
    public String approveStudent(@PathVariable String id) {
        Student s = service.getStudentById(id);
        if (s != null) {
            s.setApproved(true);
            service.saveStudent(s);
        }
        return "redirect:/admin/students";
    }

    // Placements
    @GetMapping("/placements")
    public String managePlacements(Model model) {
        model.addAttribute("placements", service.getAllPlacements());
        model.addAttribute("newPlacement", new Placement());
        return "admin/placements";
    }

    @PostMapping("/placement/add")
    public String addPlacement(@ModelAttribute Placement placement, 
                               @RequestParam(value = "studentPhoto", required = false) MultipartFile studentPhoto,
                               @RequestParam(value = "companyLogo", required = false) MultipartFile companyLogo) {
        try {
            if (studentPhoto != null && !studentPhoto.isEmpty()) {
                placement.setStudentPhotoBase64("data:" + studentPhoto.getContentType() + ";base64," + Base64.getEncoder().encodeToString(studentPhoto.getBytes()));
            }
            if (companyLogo != null && !companyLogo.isEmpty()) {
                placement.setCompanyLogoBase64("data:" + companyLogo.getContentType() + ";base64," + Base64.getEncoder().encodeToString(companyLogo.getBytes()));
            }
        } catch (Exception e) {}
        service.savePlacement(placement);
        return "redirect:/admin/placements";
    }

    @GetMapping("/placement/delete/{id}")
    public String deletePlacement(@PathVariable String id) {
        service.deletePlacement(id);
        return "redirect:/admin/placements";
    }

    @GetMapping("/placement/toggle/{id}")
    public String togglePlacementVisibility(@PathVariable String id) {
        Placement p = service.getPlacementById(id);
        if (p != null) {
            p.setHidden(!p.isHidden());
            service.savePlacement(p);
        }
        return "redirect:/admin/placements";
    }

    // Contacts
    @GetMapping("/contacts")
    public String manageContacts(Model model) {
        model.addAttribute("contacts", service.getAllContactMessages());
        return "admin/contacts";
    }

    @GetMapping("/contact/delete/{id}")
    public String deleteContact(@PathVariable String id) {
        service.deleteContactMessage(id);
        return "redirect:/admin/contacts";
    }

    // Reviews
    @GetMapping("/reviews")
    public String manageReviews(Model model) {
        model.addAttribute("reviews", service.getAllReviews());
        return "admin/reviews";
    }

    @GetMapping("/review/status/{id}/{status}")
    public String updateReviewStatus(@PathVariable String id, @PathVariable String status) {
        Review r = service.getReviewById(id);
        if (r != null) {
            r.setStatus(status);
            service.saveReview(r);
        }
        return "redirect:/admin/reviews";
    }

    @GetMapping("/review/delete/{id}")
    public String deleteReview(@PathVariable String id) {
        service.deleteReview(id);
        return "redirect:/admin/reviews";
    }

    @GetMapping("/review/pin/{id}")
    public String togglePinReview(@PathVariable String id) {
        Review r = service.getReviewById(id);
        if (r != null) {
            r.setPinned(!r.isPinned());
            service.saveReview(r);
        }
        return "redirect:/admin/reviews";
    }

    // Settings
    @GetMapping("/settings")
    public String manageSettings(Model model) {
        model.addAttribute("settings", service.getSiteSettings());
        return "admin/settings";
    }

    @PostMapping("/settings/save")
    public String saveSettings(@ModelAttribute SiteSettings settings,
                               @RequestParam(value = "aboutImage", required = false) MultipartFile aboutImage) {
        try {
            SiteSettings existing = service.getSiteSettings();
            if (aboutImage != null && !aboutImage.isEmpty()) {
                settings.setAboutImageBase64("data:" + aboutImage.getContentType() + ";base64," + Base64.getEncoder().encodeToString(aboutImage.getBytes()));
            } else {
                settings.setAboutImageBase64(existing.getAboutImageBase64());
            }
        } catch (Exception e) {}
        service.saveSiteSettings(settings);
        return "redirect:/admin/settings";
    }

    // Gallery
    @GetMapping("/gallery")
    public String manageGallery(Model model) {
        model.addAttribute("images", service.getAllGalleryImages());
        model.addAttribute("newImage", new GalleryImage());
        return "admin/gallery";
    }

    @PostMapping("/gallery/add")
    public String addGalleryImage(@ModelAttribute GalleryImage image, 
                                  @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                image.setImageBase64("data:" + imageFile.getContentType() + ";base64," + Base64.getEncoder().encodeToString(imageFile.getBytes()));
            }
        } catch (Exception e) {}
        service.saveGalleryImage(image);
        return "redirect:/admin/gallery";
    }

    @GetMapping("/gallery/delete/{id}")
    public String deleteGalleryImage(@PathVariable String id) {
        service.deleteGalleryImage(id);
        return "redirect:/admin/gallery";
    }

    @GetMapping("/gallery/toggle/{id}")
    public String toggleGalleryImage(@PathVariable String id) {
        GalleryImage g = service.getGalleryImageById(id);
        if (g != null) {
            g.setHidden(!g.isHidden());
            service.saveGalleryImage(g);
        }
        return "redirect:/admin/gallery";
    }

    // Notifications
    @GetMapping("/notifications")
    public String manageNotifications(Model model) {
        model.addAttribute("notifications", service.getAllNotifications());
        model.addAttribute("batches", service.getAllBatches());
        model.addAttribute("newNotification", new Notification());
        return "admin/notifications";
    }

    @PostMapping("/notification/add")
    public String addNotification(@ModelAttribute Notification notification) {
        if (notification.getDate() == null || notification.getDate().isEmpty()) {
            notification.setDate(java.time.LocalDate.now().toString());
        }
        service.saveNotification(notification);
        return "redirect:/admin/notifications";
    }

    @GetMapping("/notification/delete/{id}")
    public String deleteNotification(@PathVariable String id) {
        service.deleteNotification(id);
        return "redirect:/admin/notifications";
    }
}
