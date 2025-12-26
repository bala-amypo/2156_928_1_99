package com.example.demo.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DepreciationRuleEntity;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DepreciationRuleRepository;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private DepreciationRuleRepository depreciationRuleRepository;

    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Asset getAssetById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
    }

    public double calculateCurrentValue(Long assetId) {

        Asset asset = getAssetById(assetId);

        DepreciationRuleEntity rule = depreciationRuleRepository
                .findByAssetType(asset.getName())
                .orElseThrow(() -> new RuntimeException("Depreciation rule not found"));

        long yearsUsed = ChronoUnit.YEARS.between(
                asset.getPurchaseDate(),
                LocalDate.now()
        );

        double depreciationAmount =
                asset.getCost() * rule.getDepreciationRate() * yearsUsed;

        double currentValue = asset.getCost() - depreciationAmount;

        return Math.max(currentValue, 0);
    }
}
