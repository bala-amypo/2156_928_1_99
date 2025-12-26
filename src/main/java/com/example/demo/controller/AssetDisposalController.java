package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disposals")
public class AssetDisposalController {

    @Autowired private AssetDisposalRepository disposalRepository;
    @Autowired private AssetRepository assetRepository;
    @Autowired private UserRepository userRepository;

    @PostMapping("/request/{assetId}")
    public ResponseEntity<AssetDisposal> requestDisposal(
            @PathVariable Long assetId,
            @RequestBody AssetDisposal disposal) {

        Asset asset = assetRepository.findById(assetId).orElseThrow();
        disposal.setAsset(asset);

        return ResponseEntity.ok(disposalRepository.save(disposal));
    }

    @PutMapping("/approve/{disposalId}/{userId}")
    public ResponseEntity<AssetDisposal> approve(
            @PathVariable Long disposalId,
            @PathVariable Long userId) {

        AssetDisposal disposal = disposalRepository.findById(disposalId).orElseThrow();
        User approver = userRepository.findById(userId).orElseThrow();

        disposal.setApprovedBy(approver);
        disposal.getAsset().setStatus("DISPOSED");

        return ResponseEntity.ok(disposalRepository.save(disposal));
    }
}
