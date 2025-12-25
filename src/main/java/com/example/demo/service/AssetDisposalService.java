package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AssetDisposalService {

    public String disposeAsset(Long assetId, String reason) {
        // business logic placeholder
        return "Asset " + assetId + " disposed successfully. Reason: " + reason;
    }
}
