package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetTag;
    private String assetName;
    private double purchaseCost;
    private LocalDate purchaseDate;
    private String status = "ACTIVE";

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DepreciationRule depreciationRule;

    // ===== ALIASES REQUIRED =====
    public String getName() {
        return assetName;
    }

    public double getCost() {
        return purchaseCost;
    }

    // ===== Normal Getters & Setters =====
    public Long getId() {
        return id;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public double getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public DepreciationRule getDepreciationRule() {
        return depreciationRule;
    }

    public void setDepreciationRule(DepreciationRule depreciationRule) {
        this.depreciationRule = depreciationRule;
    }
}
