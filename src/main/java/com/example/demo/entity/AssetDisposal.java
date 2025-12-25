package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class AssetDisposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Asset asset;

    private String disposalMethod;
    private double disposalValue;
    private LocalDate disposalDate;

    @ManyToOne
    private User approvedBy;

    private LocalDateTime createdAt;

    public AssetDisposal() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Asset getAsset() { return asset; }
    public String getDisposalMethod() { return disposalMethod; }
    public double getDisposalValue() { return disposalValue; }
    public LocalDate getDisposalDate() { return disposalDate; }
    public User getApprovedBy() { return approvedBy; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setAsset(Asset asset) { this.asset = asset; }
    public void setDisposalMethod(String disposalMethod) { this.disposalMethod = disposalMethod; }
    public void setDisposalValue(double disposalValue) { this.disposalValue = disposalValue; }
    public void setDisposalDate(LocalDate disposalDate) { this.disposalDate = disposalDate; }
    public void setApprovedBy(User approvedBy) { this.approvedBy = approvedBy; }
}
