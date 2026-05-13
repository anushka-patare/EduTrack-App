package com.edutrack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "settings")
public class SiteSettings {
    @Id
    private String id; // We will always use "global"

    // Contact Info
    private String mobileNumber;
    private String email;
    private String address;
    private String googleMapUrl;
    private String workingHours;
    private String facebookUrl;
    private String instagramUrl;
    private String linkedinUrl;
    
    // About Us Info
    private String instituteIntro;
    private String visionMission;
    private String founderInfo;
    private String whyChooseUs;
    private String trainingMethodology;
    private String achievements;
    private int studentStats;
    private int placementStats;
    private String technologiesTaught;
    private String aboutImageBase64;

    public SiteSettings() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getGoogleMapUrl() { return googleMapUrl; }
    public void setGoogleMapUrl(String googleMapUrl) { this.googleMapUrl = googleMapUrl; }

    public String getWorkingHours() { return workingHours; }
    public void setWorkingHours(String workingHours) { this.workingHours = workingHours; }

    public String getFacebookUrl() { return facebookUrl; }
    public void setFacebookUrl(String facebookUrl) { this.facebookUrl = facebookUrl; }

    public String getInstagramUrl() { return instagramUrl; }
    public void setInstagramUrl(String instagramUrl) { this.instagramUrl = instagramUrl; }

    public String getLinkedinUrl() { return linkedinUrl; }
    public void setLinkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; }

    public String getInstituteIntro() { return instituteIntro; }
    public void setInstituteIntro(String instituteIntro) { this.instituteIntro = instituteIntro; }

    public String getVisionMission() { return visionMission; }
    public void setVisionMission(String visionMission) { this.visionMission = visionMission; }

    public String getFounderInfo() { return founderInfo; }
    public void setFounderInfo(String founderInfo) { this.founderInfo = founderInfo; }

    public String getWhyChooseUs() { return whyChooseUs; }
    public void setWhyChooseUs(String whyChooseUs) { this.whyChooseUs = whyChooseUs; }

    public String getTrainingMethodology() { return trainingMethodology; }
    public void setTrainingMethodology(String trainingMethodology) { this.trainingMethodology = trainingMethodology; }

    public String getAchievements() { return achievements; }
    public void setAchievements(String achievements) { this.achievements = achievements; }

    public int getStudentStats() { return studentStats; }
    public void setStudentStats(int studentStats) { this.studentStats = studentStats; }

    public int getPlacementStats() { return placementStats; }
    public void setPlacementStats(int placementStats) { this.placementStats = placementStats; }

    public String getTechnologiesTaught() { return technologiesTaught; }
    public void setTechnologiesTaught(String technologiesTaught) { this.technologiesTaught = technologiesTaught; }

    public String getAboutImageBase64() { return aboutImageBase64; }
    public void setAboutImageBase64(String aboutImageBase64) { this.aboutImageBase64 = aboutImageBase64; }
}
