package com.example.demo.service;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetDisposal;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetDisposalRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {

    @Autowired
    private AssetDisposalRepository assetDisposalRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AssetDisposal requestDisposal(Long assetId, AssetDisposal disposal) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
        
        disposal.setAsset(asset);
        disposal.setApproved(false);
        
        return assetDisposalRepository.save(disposal);
    }

    @Override
    public AssetDisposal approveDisposal(Long disposalId, String approverEmail) {
        AssetDisposal disposal = assetDisposalRepository.findById(disposalId)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal request not found"));
        
        User approver = userRepository.findByEmail(approverEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Approver not found"));
        
        disposal.setApproved(true);
        disposal.setApprovedBy(approver);
        
        return assetDisposalRepository.save(disposal);
    }
}