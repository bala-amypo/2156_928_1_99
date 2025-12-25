package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetDisposal;
import com.example.demo.repository.AssetDisposalRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetDisposalService;

@Service
@Transactional
public class AssetDisposalServiceImpl implements AssetDisposalService {

    private final AssetDisposalRepository disposalRepository;
    private final AssetRepository assetRepository;

    public AssetDisposalServiceImpl(
            AssetDisposalRepository disposalRepository,
            AssetRepository assetRepository) {
        this.disposalRepository = disposalRepository;
        this.assetRepository = assetRepository;
    }

    // REQUEST DISPOSAL
    @Override
    public AssetDisposal requestDisposal(Long assetId, AssetDisposal disposal) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        disposal.setAsset(asset);
        disposal.setStatus("REQUESTED");

        return disposalRepository.save(disposal);
    }

    // APPROVE DISPOSAL
    @Override
    public AssetDisposal approveDisposal(Long disposalId, String approvedBy) {

        AssetDisposal disposal = disposalRepository.findById(disposalId)
                .orElseThrow(() -> new RuntimeException("Disposal not found"));

        disposal.setApprovedBy(approvedBy);
        disposal.setStatus("APPROVED");

        Asset asset = disposal.getAsset();
        asset.setStatus("DISPOSED");

        assetRepository.save(asset);
        return disposalRepository.save(disposal);
    }
}
