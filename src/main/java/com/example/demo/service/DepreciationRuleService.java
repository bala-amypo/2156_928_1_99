package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.repository.DepreciationRuleRepository;

@Service
public class DepreciationRuleService {

    @Autowired
    private DepreciationRuleRepository repository;

    public DepreciationRule saveRule(DepreciationRule rule) {
        return repository.save(rule);
    }

    public double getSalvageValueByType(String assetType) {
        DepreciationRule rule = repository.findByAssetType(assetType)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
        return rule.getSalvageValue();
    }
}
