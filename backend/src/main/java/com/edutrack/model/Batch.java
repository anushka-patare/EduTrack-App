package com.edutrack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "batches")
public class Batch {
    @Id
    private String id;
    private String name;
    private String duration;
    private double totalFees;
    private String description;
    private String syllabus;
    private LocalDate startDate;
    private LocalDate endDate;

    public Batch() {}

    public Batch(String name, String duration, double totalFees, String description, String syllabus, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.duration = duration;
        this.totalFees = totalFees;
        this.description = description;
        this.syllabus = syllabus;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public double getTotalFees() { return totalFees; }
    public void setTotalFees(double totalFees) { this.totalFees = totalFees; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSyllabus() { return syllabus; }
    public void setSyllabus(String syllabus) { this.syllabus = syllabus; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    
    @Override
    public String toString() { return name; }
}
