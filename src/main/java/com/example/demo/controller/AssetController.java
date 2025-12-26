package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public Asset createAsset(@RequestBody Asset asset) {

        if (asset.getVendor() != null && asset.getVendor().getName() != null) {
            Vendor vendor = vendorRepository
                    .findByName(asset.getVendor().getName())
                    .orElseThrow(() -> new RuntimeException("Vendor not found"));
            asset.setVendor(vendor);
        }

        return assetRepository.save(asset);
    }

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @PutMapping("/{id}")
    public Asset updateAsset(@PathVariable Long id,
                             @RequestBody Asset updatedAsset) {

        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        asset.setName(updatedAsset.getName());
        asset.setPurchaseDate(updatedAsset.getPurchaseDate());
        asset.setCost(updatedAsset.getCost());
        asset.setStatus(updatedAsset.getStatus());

        return assetRepository.save(asset);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAsset(@PathVariable Long id) {
        assetRepository.deleteById(id);
        return ResponseEntity.ok("Asset deleted");
    }
}
