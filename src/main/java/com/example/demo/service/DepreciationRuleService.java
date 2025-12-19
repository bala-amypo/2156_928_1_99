package com.example.demo.service;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.repository.DepreciationRuleRepository;
import org.springframework.stereotype.Service;

@Service
public class DepreciationRuleService {

    private final DepreciationRuleRepository repository;

    public DepreciationRuleService(DepreciationRuleRepository repository) {
        this.repository = repository;
    }

    public DepreciationRule save(DepreciationRule rule) {
        return repository.save(rule);
    }
}
