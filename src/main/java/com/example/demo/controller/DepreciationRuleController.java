package com.example.demo.controller;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.service.DepreciationRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Depreciation Rules")
public class DepreciationRuleController {

    private final DepreciationRuleService service;

    public DepreciationRuleController(DepreciationRuleService service) {
        this.service = service;
    }

    // POST /api/rules
    @PostMapping
    public ResponseEntity<DepreciationRule> createRule(
            @RequestBody DepreciationRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    // GET /api/rules
    @GetMapping
    public ResponseEntity<List<DepreciationRule>> getAllRules() {
        return ResponseEntity.ok(service.getAllRules());
    }
}
