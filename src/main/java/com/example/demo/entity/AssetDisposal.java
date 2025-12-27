package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "asset_disposal")
public class AssetDisposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean approved;

    @Column(name = "disposal_method")
    private String disposalMethod;

    @Column(name = "disposal_value")
    private double disposalValue;

    @Column(name = "disposal_date")
    private LocalDate disposalDate;

    @ManyToOne
    @JoinColumn(name = "approved_by_id")
    private User approvedBy;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    public AssetDisposal() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }

    public String getDisposalMethod() { return disposalMethod; }
    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public double getDisposalValue() { return disposalValue; }
    public void setDisposalValue(double disposalValue) {
        this.disposalValue = disposalValue;
    }

    public LocalDate getDisposalDate() { return disposalDate; }
    public void setDisposalDate(LocalDate disposalDate) {
        this.disposalDate = disposalDate;
    }

    public User getApprovedBy() { return approvedBy; }
    public void setApprovedBy(User approvedBy) { this.approvedBy = approvedBy; }

    public Asset getAsset() { return asset; }
    public void setAsset(Asset asset) { this.asset = asset; }
}
