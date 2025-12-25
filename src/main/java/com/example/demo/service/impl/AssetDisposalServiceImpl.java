package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetDisposal;
import com.example.demo.entity.User;
import com.example.demo.repository.AssetDisposalRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AssetDisposalService;
import org.springframework.stereotype.Service;

@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {

    private final AssetDisposalRepository disposalRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public AssetDisposalServiceImpl(AssetDisposalRepository disposalRepository,
                                   AssetRepository assetRepository,
                                   UserRepository userRepository) {
        this.disposalRepository = disposalRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AssetDisposal requestDisposal(Long assetId, AssetDisposal disposal) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
        disposal.setAsset(asset);
        return disposalRepository.save(disposal);
    }

    @Override
    public AssetDisposal approveDisposal(Long disposalId, String approverEmail) {
        AssetDisposal disposal = disposalRepository.findById(disposalId)
                .orElseThrow(() -> new RuntimeException("Disposal not found"));
        User approver = userRepository.findByEmail(approverEmail)
                .orElseThrow(() -> new RuntimeException("Approver not found"));
        disposal.setApprovedBy(approver);
        return disposalRepository.save(disposal);
    }
}