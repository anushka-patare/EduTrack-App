package com.edutrack.repository;
import com.edutrack.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByTargetBatchIn(List<String> targetBatches);
}
