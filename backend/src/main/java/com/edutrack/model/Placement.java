package com.edutrack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "placements")
public class Placement {
    @Id
    private String id;
    private String companyName;
    private String studentName;
    private String studentPhotoBase64;
    private String packageSalary;
    private String technology;
    private String placementDate;
    private String companyLogoBase64;
    private String successStory;
    private boolean isHidden;

    public Placement() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    
    public String getStudentPhotoBase64() { return studentPhotoBase64; }
    public void setStudentPhotoBase64(String studentPhotoBase64) { this.studentPhotoBase64 = studentPhotoBase64; }
    
    public String getPackageSalary() { return packageSalary; }
    public void setPackageSalary(String packageSalary) { this.packageSalary = packageSalary; }
    
    public String getTechnology() { return technology; }
    public void setTechnology(String technology) { this.technology = technology; }
    
    public String getPlacementDate() { return placementDate; }
    public void setPlacementDate(String placementDate) { this.placementDate = placementDate; }
    
    public String getCompanyLogoBase64() { return companyLogoBase64; }
    public void setCompanyLogoBase64(String companyLogoBase64) { this.companyLogoBase64 = companyLogoBase64; }
    
    public String getSuccessStory() { return successStory; }
    public void setSuccessStory(String successStory) { this.successStory = successStory; }
    
    public boolean isHidden() { return isHidden; }
    public void setHidden(boolean isHidden) { this.isHidden = isHidden; }
}
