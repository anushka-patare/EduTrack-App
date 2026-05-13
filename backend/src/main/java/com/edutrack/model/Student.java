package com.edutrack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
    private String batch;
    private String gender;
    private double feesPaid;
    private double feesRemaining;

    public Student() {}

    public Student(String name, String email, String gender, String batch, double feesPaid, double feesRemaining) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.batch = batch;
        this.feesPaid = feesPaid;
        this.feesRemaining = feesRemaining;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getBatch() { return batch; }
    public void setBatch(String batch) { this.batch = batch; }
    public double getFeesPaid() { return feesPaid; }
    public void setFeesPaid(double feesPaid) { this.feesPaid = feesPaid; }
    public double getFeesRemaining() { return feesRemaining; }
    public void setFeesRemaining(double feesRemaining) { this.feesRemaining = feesRemaining; }

    // New Fields
    private String password;
    private String mobile;
    private String address;
    private String profilePhotoBase64;
    private String joiningDate;
    private boolean isApproved;

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getProfilePhotoBase64() { return profilePhotoBase64; }
    public void setProfilePhotoBase64(String profilePhotoBase64) { this.profilePhotoBase64 = profilePhotoBase64; }
    public String getJoiningDate() { return joiningDate; }
    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; }
    public boolean isApproved() { return isApproved; }
    public void setApproved(boolean approved) { isApproved = approved; }
}
