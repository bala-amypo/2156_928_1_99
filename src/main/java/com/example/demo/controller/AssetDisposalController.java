package com.example.demo.controller;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.service.AssetDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disposals")
public class AssetDisposalController {

    @Autowired
    private AssetDisposalService assetDisposalService;

    @PostMapping("/request/{assetId}")
    public AssetDisposal requestDisposal(@PathVariable Long assetId) {
        return assetDisposalService.requestDisposal(assetId);
    }

    @PutMapping("/approve/{disposalId}/{userId}")
    public AssetDisposal approveDisposal(
            @PathVariable Long disposalId,
            @PathVariable Long userId) {
        return assetDisposalService.approveDisposal(disposalId, userId);
    }
}
