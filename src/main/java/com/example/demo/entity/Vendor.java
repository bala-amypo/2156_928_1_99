package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;   // IMPORTANT: field name is "name"

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {      // NOT getVendorName()
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
