package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "depreciation_rules", uniqueConstraints = @UniqueConstraint(columnNames = "ruleName"))
public class DepreciationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleName;

    private String method;
    private int usefulLifeYears;
    private double salvageValue;

    // getters & setters
}
