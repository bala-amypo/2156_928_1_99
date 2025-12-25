package com.example.demo.controller;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.service.AssetDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assetDisposals")
public class AssetDisposalController {

    @Autowired
    private AssetDisposalService disposalService;

    // Create a new disposal for a user
    @PostMapping("/user/{userId}")
    public ResponseEntity<AssetDisposal> createDisposal(
            @PathVariable Long userId,
            @RequestBody AssetDisposal disposalRequest
    ) {
        AssetDisposal savedDisposal = disposalService.createDisposal(userId, disposalRequest);
        return ResponseEntity.ok(savedDisposal);
    }

    // Update status of a disposal
    @PutMapping("/{disposalId}/status")
    public ResponseEntity<AssetDisposal> updateDisposalStatus(
            @PathVariable Long disposalId,
            @RequestParam String status
    ) {
        AssetDisposal updatedDisposal = disposalService.updateDisposalStatus(disposalId, status);
        return ResponseEntity.ok(updatedDisposal);
    }

    // Optional: Get disposal by ID
    @GetMapping("/{disposalId}")
    public ResponseEntity<AssetDisposal> getDisposal(@PathVariable Long disposalId) {
        AssetDisposal disposal = disposalService.updateDisposalStatus(disposalId, null); // or create a findById method
        return ResponseEntity.ok(disposal);
    }
}
