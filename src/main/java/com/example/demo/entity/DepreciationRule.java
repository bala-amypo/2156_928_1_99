package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DepreciationRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ruleName;
    private String method; // e.g., STRAIGHT_LINE, DECLINING_BALANCE

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
}
