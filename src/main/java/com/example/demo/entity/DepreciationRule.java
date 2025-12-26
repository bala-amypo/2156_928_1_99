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
    private String ruleName;
    private String method;
    private int usefulLifeYears;

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

    public String getRuleName() {
        return ruleName;
    }

    public String getMethod() {
        return method;
    }

    public int getUsefulLifeYears() {
        return usefulLifeYears;
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

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUsefulLifeYears(int usefulLifeYears) {
        this.usefulLifeYears = usefulLifeYears;
    }
}
