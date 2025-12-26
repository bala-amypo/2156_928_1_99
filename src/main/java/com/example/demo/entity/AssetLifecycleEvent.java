package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AssetLifecycleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate eventDate;
    private String eventDescription;

    @ManyToOne
    private Asset asset;

    // Getters and Setters

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public LocalDate getEventDate() {
        return eventDate;
    }
 
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
 
    public String getEventDescription() {
        return eventDescription;
    }
 
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
 
    public Asset getAsset() {
        return asset;
    }
 
    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
