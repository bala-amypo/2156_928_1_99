package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DepreciationRule;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DepreciationRuleRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private DepreciationRuleRepository depreciationRuleRepository;

    @Override
    public Asset createAsset(Long vendorId, Long ruleId, Asset asset) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();
        DepreciationRule rule = depreciationRuleRepository.findById(ruleId).orElseThrow();

        asset.setVendor(vendor);
        asset.setDepreciationRule(rule);
        asset.setStatus("ACTIVE");

        return assetRepository.save(asset);
    }

    @Override
    public Asset updateAsset(Long id, Asset updatedAsset) {
        Asset asset = assetRepository.findById(id).orElseThrow();

        asset.setAssetName(updatedAsset.getAssetName());
        asset.setAssetTag(updatedAsset.getAssetTag());
        asset.setAssetType(updatedAsset.getAssetType());
        asset.setPurchaseCost(updatedAsset.getPurchaseCost());
        asset.setPurchaseDate(updatedAsset.getPurchaseDate());
        asset.setStatus(updatedAsset.getStatus());

        return assetRepository.save(asset);
    }
}
