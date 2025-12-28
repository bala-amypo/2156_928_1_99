package com.example.demo.service;

import com.example.demo.entity.Asset;

import java.util.List;

public interface AssetService {

    Asset createAsset(Long vendorId, Long ruleId, Asset asset);

    Asset updateAsset(Long id, Asset asset);

    List<Asset> getAllAssets();

    Asset getAssetById(Long id);

    List<Asset> getAssetsByStatus(String status);
}
