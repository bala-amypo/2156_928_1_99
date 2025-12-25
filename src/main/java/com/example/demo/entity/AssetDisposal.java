package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "asset_disposals")
public class AssetDisposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;  // Status of disposal (e.g., PENDING, APPROVED, REJECTED)

    private String assetName; // Example field for asset

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public AssetDisposal() {}

    public AssetDisposal(String assetName, String status, User user) {
        this.assetName = assetName;
        this.status = status;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
