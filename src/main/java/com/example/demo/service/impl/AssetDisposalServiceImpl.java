package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.entity.AssetStatus;
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

    @Override
    public AssetDisposal requestDisposal(AssetDisposal disposal) {
        return disposalRepository.save(disposal);
    }

    @Override
    public AssetDisposal approveDisposal(Long id) {

        AssetDisposal disposal = disposalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disposal not found"));

        disposal.getAsset().setStatus(AssetStatus.DISPOSED);
        assetRepository.save(disposal.getAsset());

        return disposal;
    }
}
