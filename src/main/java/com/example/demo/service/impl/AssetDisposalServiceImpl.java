package com.example.demo.service.impl;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.entity.User;
import com.example.demo.repository.AssetDisposalRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AssetDisposalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {

    @Autowired
    private AssetDisposalRepository assetDisposalRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AssetDisposal createDisposal(AssetDisposal disposal) {
        User user = userRepository.findById(disposal.getDisposedBy().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        disposal.setDisposedBy(user);
        disposal.setStatus("DISPOSED");

        return assetDisposalRepository.save(disposal);
    }

    @Override
    public List<AssetDisposal> getAllDisposals() {
        return assetDisposalRepository.findAll();
    }
}
