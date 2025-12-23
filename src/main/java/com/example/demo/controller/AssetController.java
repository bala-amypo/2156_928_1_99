package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
@CrossOrigin
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    // CREATE Asset
    @PostMapping
    public Asset createAsset(@RequestBody Asset asset) {
        return assetService.save(asset);
    }

    // READ Assets
    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.findAll();
    }
}
