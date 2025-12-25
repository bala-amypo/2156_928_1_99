package com.example.demo.controller;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.service.AssetDisposalService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disposals")
public class AssetDisposalController {

    private final AssetDisposalService disposalService;

    public AssetDisposalController(AssetDisposalService disposalService) {
        this.disposalService = disposalService;
    }

    @PostMapping("/{assetId}")
    public AssetDisposal request(
            @PathVariable Long assetId,
            @RequestBody AssetDisposal disposal
    ) {
        return disposalService.requestDisposal(assetId, disposal);
    }

    @PostMapping("/approve/{disposalId}")
    public AssetDisposal approve(
            @PathVariable Long disposalId,
            Authentication authentication
    ) {
        return disposalService.approveDisposal(disposalId, authentication.getName());
    }
}
