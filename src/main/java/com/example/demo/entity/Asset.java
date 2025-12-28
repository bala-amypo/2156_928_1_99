package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String assetTag;

    private String assetName;

    private String assetType;

    private double purchaseCost;

    private String status;

    private LocalDate purchaseDate;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DepreciationRule depreciationRule;

    // ✅ REQUIRED getters/setters

    public String getName() {
        return assetName;
    }

    public void setName(String assetName) {
        this.assetName = assetName;
    }

    public double getCost() {
        return purchaseCost;
    }

    public void setCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
