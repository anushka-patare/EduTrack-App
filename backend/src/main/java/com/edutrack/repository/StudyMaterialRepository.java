package com.edutrack.repository;
import com.edutrack.model.StudyMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface StudyMaterialRepository extends MongoRepository<StudyMaterial, String> {
    List<StudyMaterial> findByBatchName(String batchName);
}
