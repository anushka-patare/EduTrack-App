package com.edutrack.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "assignments")
public class Assignment {
    @Id
    private String id;
    private String title;
    private String description;
    private String batchName;
    private String deadline;
    private String fileBase64;

    public Assignment() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getBatchName() { return batchName; }
    public void setBatchName(String batchName) { this.batchName = batchName; }
    public String getDeadline() { return deadline; }
    public void setDeadline(String deadline) { this.deadline = deadline; }
    public String getFileBase64() { return fileBase64; }
    public void setFileBase64(String fileBase64) { this.fileBase64 = fileBase64; }
}
