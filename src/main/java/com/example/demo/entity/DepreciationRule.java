package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DepreciationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetType;
    private double rate;
    private double salvageValue;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getAssetType() {
        return assetType;
    }

    public double getRate() {
        return rate;
    }

    public double getSalvageValue() {
        return salvageValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setSalvageValue(double salvageValue) {
        this.salvageValue = salvageValue;
    }
}
