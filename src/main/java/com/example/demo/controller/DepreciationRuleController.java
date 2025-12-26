package com.example.demo.controller;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.repository.DepreciationRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
public class DepreciationRuleController {

    @Autowired
    private DepreciationRuleRepository ruleRepository;

    @PostMapping
    public ResponseEntity<DepreciationRule> create(@RequestBody DepreciationRule rule) {
        return ResponseEntity.ok(ruleRepository.save(rule));
    }
}
