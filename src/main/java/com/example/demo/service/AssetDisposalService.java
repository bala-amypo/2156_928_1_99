package com.example.demo.service;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetDisposal;
import com.example.demo.entity.User;
import com.example.demo.repository.AssetDisposalRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetDisposalService {

    @Autowired private AssetDisposalRepository disposalRepository;
    @Autowired private AssetRepository assetRepository;
    @Autowired private UserRepository userRepository;

    public AssetDisposal requestDisposal(Long assetId, AssetDisposal disposal) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        disposal.setAsset(asset);

        return disposalRepository.save(disposal);
    }

    public AssetDisposal approveDisposal(Long disposalId, Long userId) {

        AssetDisposal disposal = disposalRepository.findById(disposalId)
                .orElseThrow(() -> new RuntimeException("Disposal not found"));

        User approver = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        disposal.setApprovedBy(approver);
        disposal.getAsset().setStatus("DISPOSED");

        return disposalRepository.save(disposal);
    }
}
