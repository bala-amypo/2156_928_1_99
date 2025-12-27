package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@Tag(name = "Assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    // POST /api/assets/{vendorId}/{ruleId}
    @PostMapping("/{vendorId}/{ruleId}")
    public ResponseEntity<Asset> createAsset(
            @PathVariable Long vendorId,
            @PathVariable Long ruleId,
            @RequestBody Asset asset) {
        return ResponseEntity.ok(assetService.createAsset(vendorId, ruleId, asset));
    }

    // GET /api/assets
    @GetMapping
    public ResponseEntity<List<Asset>> getAllAssets() {
        return ResponseEntity.ok(assetService.getAllAssets());
    }

    // GET /api/assets/status/{status}
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Asset>> getAssetsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(assetService.getAssetsByStatus(status));
    }

    // GET /api/assets/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
        return ResponseEntity.ok(assetService.getAssetById(id));
    }
}
