package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AssetDisposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate disposalDate;
    private boolean approved;
    private String disposalMethod;
    private double disposalValue;

    @ManyToOne
    private Asset asset;

    @ManyToOne
    private User approvedBy;

    // Getters and Setters

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public LocalDate getDisposalDate() {
        return disposalDate;
    }
 
    public void setDisposalDate(LocalDate disposalDate) {
        this.disposalDate = disposalDate;
    }
 
    public boolean isApproved() {
        return approved;
    }
 
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getDisposalMethod() {
        return disposalMethod;
    }

    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public double getDisposalValue() {
        return disposalValue;
    }

    public void setDisposalValue(double disposalValue) {
        this.disposalValue = disposalValue;
    }
 
    public Asset getAsset() {
        return asset;
    }
 
    public void setAsset(Asset asset) {
        this.asset = asset;
    }
 
    public User getApprovedBy() {
        return approvedBy;
    }
 
    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }
}
