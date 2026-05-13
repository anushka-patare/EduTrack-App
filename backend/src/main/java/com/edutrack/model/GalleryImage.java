package com.edutrack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gallery_images")
public class GalleryImage {
    @Id
    private String id;
    private String title;
    private String imageBase64;
    private boolean isHidden;

    public GalleryImage() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getImageBase64() { return imageBase64; }
    public void setImageBase64(String imageBase64) { this.imageBase64 = imageBase64; }
    
    public boolean isHidden() { return isHidden; }
    public void setHidden(boolean isHidden) { this.isHidden = isHidden; }
}
