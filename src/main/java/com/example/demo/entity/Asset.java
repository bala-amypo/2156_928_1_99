package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assets", uniqueConstraints = @UniqueConstraint(columnNames = "assetTag"))
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String assetTag;

    private String assetName;
    private LocalDate purchaseDate;
    private double purchaseCost;

    private String status = "ACTIVE";

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DepreciationRule depreciationRule;

    // getters & setters
}
