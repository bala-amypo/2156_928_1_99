package com.example.demo.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DepreciationRule;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DepreciationRuleRepository;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private DepreciationRuleRepository depreciationRuleRepository;

    public double calculateCurrentValue(Long assetId) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        DepreciationRule rule = depreciationRuleRepository
                .findByAssetType(asset.getName())
                .orElseThrow(() -> new RuntimeException("Depreciation rule not found"));

        long yearsUsed = ChronoUnit.YEARS.between(
                asset.getPurchaseDate(),
                LocalDate.now()
        );

        double depreciation = asset.getCost() * rule.getRate() * yearsUsed;
        double currentValue = asset.getCost() - depreciation;

        return Math.max(currentValue, rule.getSalvageValue());
    }
}
