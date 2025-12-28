package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    // ✅ CREATE ASSET
    @PostMapping
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        return ResponseEntity.ok(assetService.createAsset(asset));
    }

    // ✅ UPDATE ASSET (IMPORTANT FOR TEST CASES)
    @PutMapping("/{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable Long id,
                                             @RequestBody Asset asset) {
        return ResponseEntity.ok(assetService.updateAsset(id, asset));
    }

    // ✅ GET ALL ASSETS
    @GetMapping
    public ResponseEntity<List<Asset>> getAllAssets() {
        return ResponseEntity.ok(assetService.getAllAssets());
    }

    // ✅ GET ASSET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
        return ResponseEntity.ok(assetService.getAssetById(id));
    }

    // ✅ GET ASSETS BY STATUS
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Asset>> getAssetsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(assetService.getAssetsByStatus(status));
    }
}
