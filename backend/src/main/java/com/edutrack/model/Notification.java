package com.edutrack.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;
    private String title;
    private String message;
    private String targetBatch; // "ALL" for all batches
    private String date;

    public Notification() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getTargetBatch() { return targetBatch; }
    public void setTargetBatch(String targetBatch) { this.targetBatch = targetBatch; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
