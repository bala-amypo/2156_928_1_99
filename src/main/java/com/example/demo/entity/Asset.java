package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String assetType;
    private double cost;
    private String status;

    private LocalDate purchaseDate;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAssetType() {
        return assetType;
    }

    public double getCost() {
        return cost;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
