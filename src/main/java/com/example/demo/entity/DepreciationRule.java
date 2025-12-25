package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DepreciationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ruleName;

    private String method;

    private int usefulLifeYears;
    private double salvageValue;
    private LocalDateTime createdAt;

    public DepreciationRule() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getRuleName() { return ruleName; }
    public String getMethod() { return method; }
    public int getUsefulLifeYears() { return usefulLifeYears; }
    public double getSalvageValue() { return salvageValue; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public void setMethod(String method) { this.method = method; }
    public void setUsefulLifeYears(int usefulLifeYears) { this.usefulLifeYears = usefulLifeYears; }
    public void setSalvageValue(double salvageValue) { this.salvageValue = salvageValue; }
}
