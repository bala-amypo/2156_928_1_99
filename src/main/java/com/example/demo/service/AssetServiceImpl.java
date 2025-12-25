package com.example.demo.service;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DepreciationRule;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DepreciationRuleRepository;
import com.example.demo.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final VendorRepository vendorRepository;
    private final DepreciationRuleRepository depreciationRuleRepository;

    public AssetServiceImpl(AssetRepository assetRepository, 
                           VendorRepository vendorRepository,
                           DepreciationRuleRepository depreciationRuleRepository) {
        this.assetRepository = assetRepository;
        this.vendorRepository = vendorRepository;
        this.depreciationRuleRepository = depreciationRuleRepository;
    }

    @Override
    public Asset createAsset(Long vendorId, Long ruleId, Asset asset) {
        Vendor vendor = vendorRepository.findById(vendorId).orElse(null);
        DepreciationRule rule = depreciationRuleRepository.findById(ruleId).orElse(null);
        
        asset.setVendor(vendor);
        asset.setDepreciationRule(rule);
        
        return assetRepository.save(asset);
    }

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset getAssetById(Long id) {
        return assetRepository.findById(id).orElse(null);
    }

    @Override
    public List<Asset> getAssetsByStatus(String status) {
        return assetRepository.findByStatus(status);
    }
}