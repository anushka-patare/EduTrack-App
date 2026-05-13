package com.edutrack.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "certificates")
public class Certificate {
    @Id
    private String id;
    private String studentId;
    private String type; // Internship, Completion
    private String issueDate;
    private String fileBase64;

    public Certificate() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getIssueDate() { return issueDate; }
    public void setIssueDate(String issueDate) { this.issueDate = issueDate; }
    public String getFileBase64() { return fileBase64; }
    public void setFileBase64(String fileBase64) { this.fileBase64 = fileBase64; }
}
