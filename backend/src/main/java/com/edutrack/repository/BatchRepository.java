package com.edutrack.repository;

import com.edutrack.model.Batch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BatchRepository extends MongoRepository<Batch, String> {
}
