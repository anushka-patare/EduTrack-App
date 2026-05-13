package com.edutrack.service;

import com.edutrack.model.*;
import com.edutrack.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;

@Service
public class EduTrackService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private PlacementRepository placementRepository;

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private SiteSettingsRepository siteSettingsRepository;

    @Autowired
    private GalleryImageRepository galleryImageRepository;

    @Autowired
    private StudyMaterialRepository studyMaterialRepository;
    
    @Autowired
    private AttendanceRepository attendanceRepository;
    
    @Autowired
    private AssignmentRepository assignmentRepository;
    
    @Autowired
    private CertificateRepository certificateRepository;
    
    @Autowired
    private NotificationRepository notificationRepository;
    
    @Autowired
    private PaymentRecordRepository paymentRecordRepository;

    // Student Operations
    public Student saveStudent(Student student) { return studentRepository.save(student); }
    public List<Student> getAllStudents() { return studentRepository.findAll(); }
    public void deleteStudent(String id) { studentRepository.deleteById(id); }
    public Student getStudentById(String id) { return studentRepository.findById(id).orElse(null); }
    public Student authenticateStudent(String email, String password) {
        return studentRepository.findAll().stream()
                .filter(s -> s.getEmail().equals(email) && password.equals(s.getPassword()))
                .findFirst().orElse(null);
    }

    // Batch Operations
    public Batch saveBatch(Batch batch) {
        if (batch.getStartDate() == null) batch.setStartDate(LocalDate.now());
        if (batch.getEndDate() == null) batch.setEndDate(LocalDate.now().plusMonths(6));
        return batchRepository.save(batch);
    }
    public List<Batch> getAllBatches() { return batchRepository.findAll(); }
    public void deleteBatch(String id) { batchRepository.deleteById(id); }

    // Placement Operations
    public Placement savePlacement(Placement placement) { return placementRepository.save(placement); }
    public List<Placement> getAllPlacements() { return placementRepository.findAll(); }
    public void deletePlacement(String id) { placementRepository.deleteById(id); }
    public Placement getPlacementById(String id) { return placementRepository.findById(id).orElse(null); }

    // Contact Operations
    public ContactMessage saveContactMessage(ContactMessage message) { return contactMessageRepository.save(message); }
    public List<ContactMessage> getAllContactMessages() { return contactMessageRepository.findAll(); }
    public void deleteContactMessage(String id) { contactMessageRepository.deleteById(id); }

    // Review Operations
    public Review saveReview(Review review) { return reviewRepository.save(review); }
    public List<Review> getAllReviews() { return reviewRepository.findAll(); }
    public void deleteReview(String id) { reviewRepository.deleteById(id); }
    public Review getReviewById(String id) { return reviewRepository.findById(id).orElse(null); }

    // SiteSettings Operations
    public SiteSettings getSiteSettings() {
        return siteSettingsRepository.findById("global").orElse(new SiteSettings());
    }
    public SiteSettings saveSiteSettings(SiteSettings settings) {
        settings.setId("global");
        return siteSettingsRepository.save(settings);
    }

    // Gallery Operations
    public GalleryImage saveGalleryImage(GalleryImage image) { return galleryImageRepository.save(image); }
    public List<GalleryImage> getAllGalleryImages() { return galleryImageRepository.findAll(); }
    public void deleteGalleryImage(String id) { galleryImageRepository.deleteById(id); }
    public GalleryImage getGalleryImageById(String id) { return galleryImageRepository.findById(id).orElse(null); }

    // Student Portal Features
    public List<Certificate> getCertificates(String studentId) { return certificateRepository.findByStudentId(studentId); }
    public List<PaymentRecord> getPaymentRecords(String studentId) { return paymentRecordRepository.findByStudentId(studentId); }
    
    public List<Notification> getAllNotifications() { return notificationRepository.findAll(); }
    public Notification saveNotification(Notification notification) { return notificationRepository.save(notification); }
    public void deleteNotification(String id) { notificationRepository.deleteById(id); }
    public List<Notification> getNotifications(String batchName) { 
        return notificationRepository.findByTargetBatchIn(java.util.Arrays.asList("ALL", batchName)); 
    }

    public PaymentRecord savePaymentRecord(PaymentRecord paymentRecord) {
        return paymentRecordRepository.save(paymentRecord);
    }
}
