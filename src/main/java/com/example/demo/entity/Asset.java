package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double purchaseCost;
    private LocalDate purchaseDate;
    private String status;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DepreciationRule depreciationRule;

    // Getters and Setters

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getPurchaseCost() {
        return purchaseCost;
    }
 
    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }
 
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
 
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
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
