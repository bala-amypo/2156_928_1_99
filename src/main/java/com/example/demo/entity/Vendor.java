package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorName;
    private String contactEmail;

    @OneToMany(mappedBy = "vendor")
    private List<Asset> assets;

    // ===== Required Aliases =====
    public String getName() {
        return vendorName;
    }

    public void setName(String name) {
        this.vendorName = name;
    }

    // ===== Normal Getters =====
    public Long getId() {
        return id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
