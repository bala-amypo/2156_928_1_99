package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AssetDisposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String disposalMethod;
    private double disposalValue;
    private LocalDate disposalDate;

    @ManyToOne
    private Asset asset;

    @ManyToOne
    private User approvedBy;

    // getters & setters
}
