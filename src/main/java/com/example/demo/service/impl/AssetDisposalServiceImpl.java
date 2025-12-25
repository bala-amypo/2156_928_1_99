package com.example.demo.service.impl;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.entity.User;
import com.example.demo.repository.AssetDisposalRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AssetDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {

    @Autowired
    private AssetDisposalRepository disposalRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AssetDisposal createDisposal(Long userId, AssetDisposal disposalRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        disposalRequest.setUser(user);
        disposalRequest.setStatus("PENDING"); // default status

        return disposalRepository.save(disposalRequest);
    }

    @Override
    public AssetDisposal updateDisposalStatus(Long disposalId, String status) {
        AssetDisposal disposal = disposalRepository.findById(disposalId)
                .orElseThrow(() -> new RuntimeException("Disposal not found"));

        disposal.setStatus(status);
        return disposalRepository.save(disposal);
    }
}
