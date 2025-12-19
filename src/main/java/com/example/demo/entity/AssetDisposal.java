package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "asset_disposals")
public class AssetDisposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // SELL, RECYCLE, SCRAP
    @Column(nullable = false)
    private String disposalMethod;

    private double disposalValue;

    // PENDING, APPROVED, REJECTED
    private String approvalStatus = "PENDING";

    private LocalDateTime requestedAt = LocalDateTime.now();

    @ManyToOne
    private Asset asset;

    public Long getId() {
        return id;
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

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
