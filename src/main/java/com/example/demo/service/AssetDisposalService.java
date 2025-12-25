package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetStatus;
import com.example.demo.repository.AssetRepository;

@Service
@Transactional
public class AssetDisposalService {

    private final AssetRepository assetRepository;

    public AssetDisposalService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    /**
     * Dispose an asset by ID
     *
     * @param assetId asset primary key
     * @param reason reason for disposal
     * @return confirmation message
     */
    public String disposeAsset(Long assetId, String reason) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + assetId));

        // Mark asset as disposed
        asset.setStatus(AssetStatus.DISPOSED);
        asset.setDisposalReason(reason);
        asset.setDisposedAt(LocalDateTime.now());

        assetRepository.save(asset);

        return "Asset disposed successfully";
    }
}
