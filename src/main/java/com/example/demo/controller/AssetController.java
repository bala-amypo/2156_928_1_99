package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Asset;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.VendorRepository;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private VendorRepository vendorRepository;

    // CREATE asset
    @PostMapping
    public ResponseEntity<?> createAsset(@RequestBody Asset asset) {

        if (asset.getVendor() != null &&
            asset.getVendor().getVendorName() != null) {

            Vendor vendor = vendorRepository
                    .findByVendorName(asset.getVendor().getVendorName())
                    .orElseThrow(() ->
                            new RuntimeException("Vendor not found"));

            asset.setVendor(vendor);
        }

        Asset savedAsset = assetRepository.save(asset);
        return new ResponseEntity<>(savedAsset, HttpStatus.CREATED);
    }

    // GET all assets
    @GetMapping
    public ResponseEntity<List<Asset>> getAllAssets() {
        return ResponseEntity.ok(assetRepository.findAll());
    }

    // GET asset by ID
    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {

        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        return ResponseEntity.ok(asset);
    }

    // UPDATE asset
    @PutMapping("/{id}")
    public ResponseEntity<Asset> updateAsset(
            @PathVariable Long id,
            @RequestBody Asset updatedAsset) {

        Asset existingAsset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        existingAsset.setAssetName(updatedAsset.getAssetName());
        existingAsset.setPurchaseDate(updatedAsset.getPurchaseDate());
        existingAsset.setCost(updatedAsset.getCost());
        existingAsset.setStatus(updatedAsset.getStatus());

        if (updatedAsset.getVendor() != null &&
            updatedAsset.getVendor().getVendorName() != null) {

            Vendor vendor = vendorRepository
                    .findByVendorName(updatedAsset.getVendor().getVendorName())
                    .orElseThrow(() ->
                            new RuntimeException("Vendor not found"));

            existingAsset.setVendor(vendor);
        }

        return ResponseEntity.ok(assetRepository.save(existingAsset));
    }

    // DELETE asset
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAsset(@PathVariable Long id) {

        if (!assetRepository.existsById(id)) {
            throw new RuntimeException("Asset not found");
        }

        assetRepository.deleteById(id);
        return ResponseEntity.ok("Asset deleted successfully");
    }
}
