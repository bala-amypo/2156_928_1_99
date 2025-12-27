package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "depreciation_rule",
    uniqueConstraints = @UniqueConstraint(columnNames = "rule_name")
)
public class DepreciationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_name", nullable = false)
    private String ruleName;

    private String method;

    private String assetType;

    private double rate;

    @Column(name = "useful_life_years")
    private int usefulLifeYears;

    @Column(name = "salvage_value")
    private double salvageValue;

    public DepreciationRule() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getAssetType() { return assetType; }
    public void setAssetType(String assetType) { this.assetType = assetType; }

    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }

    public int getUsefulLifeYears() { return usefulLifeYears; }
    public void setUsefulLifeYears(int usefulLifeYears) {
        this.usefulLifeYears = usefulLifeYears;
    }

    public double getSalvageValue() { return salvageValue; }
    public void setSalvageValue(double salvageValue) {
        this.salvageValue = salvageValue;
    }
}
