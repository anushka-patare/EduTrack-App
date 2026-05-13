package com.edutrack.repository;
import com.edutrack.model.Certificate;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface CertificateRepository extends MongoRepository<Certificate, String> {
    List<Certificate> findByStudentId(String studentId);
}
