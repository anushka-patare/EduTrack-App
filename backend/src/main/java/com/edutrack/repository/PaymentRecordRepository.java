package com.edutrack.repository;
import com.edutrack.model.PaymentRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface PaymentRecordRepository extends MongoRepository<PaymentRecord, String> {
    List<PaymentRecord> findByStudentId(String studentId);
}
