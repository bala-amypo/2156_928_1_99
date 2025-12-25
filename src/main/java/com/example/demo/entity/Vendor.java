package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String vendorName;

    @Column(nullable = false)
    private String contactEmail;

    private String phone;

    private LocalDateTime createdAt;

    public Vendor() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getVendorName() { return vendorName; }
    public String getContactEmail() { return contactEmail; }
    public String getPhone() { return phone; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    public void setPhone(String phone) { this.phone = phone; }
}
