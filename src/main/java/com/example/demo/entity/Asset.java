package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String assetTag;

    private String assetName;

    @ManyToOne
    private Vendor vendor;

    private LocalDate purchaseDate;
    private double purchaseCost;

    @ManyToOne
    private DepreciationRule depreciationRule;

    private String status;

    private LocalDateTime createdAt;

    public Asset() {
        this.status = "ACTIVE";
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getAssetTag() { return assetTag; }
    public String getAssetName() { return assetName; }
    public Vendor getVendor() { return vendor; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public double getPurchaseCost() { return purchaseCost; }
    public DepreciationRule getDepreciationRule() { return depreciationRule; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setAssetTag(String assetTag) { this.assetTag = assetTag; }
    public void setAssetName(String assetName) { this.assetName = assetName; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setPurchaseCost(double purchaseCost) { this.purchaseCost = purchaseCost; }
    public void setDepreciationRule(DepreciationRule depreciationRule) { this.depreciationRule = depreciationRule; }
    public void setStatus(String status) { this.status = status; }
}
