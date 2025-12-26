package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DepreciationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int usefulLifeYears;
    private double salvageValue;

    // Getters and Setters

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public int getUsefulLifeYears() {
        return usefulLifeYears;
    }
 
    public void setUsefulLifeYears(int usefulLifeYears) {
        this.usefulLifeYears = usefulLifeYears;
    }
 
    public double getSalvageValue() {
        return salvageValue;
    }
 
    public void setSalvageValue(double salvageValue) {
        this.salvageValue = salvageValue;
    }
}
