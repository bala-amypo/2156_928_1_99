package com.example.demo.service;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.repository.DepreciationRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepreciationRuleService {

    @Autowired
    private DepreciationRuleRepository ruleRepository;

    public DepreciationRule save(DepreciationRule rule) {

        if (rule.getUsefulLifeYears() <= 0) {
            throw new RuntimeException("Useful life must be positive");
        }

        if (rule.getSalvageValue() < 0) {
            throw new RuntimeException("Salvage value cannot be negative");
        }

        return ruleRepository.save(rule);
    }
}
