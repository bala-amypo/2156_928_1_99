package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AssetLifecycleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventType;
    private String eventDescription;
    private LocalDate eventDate;

    @ManyToOne
    private Asset asset;

    // getters & setters
}
