package com.edutrack.repository;
import com.edutrack.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    List<Assignment> findByBatchName(String batchName);
}
