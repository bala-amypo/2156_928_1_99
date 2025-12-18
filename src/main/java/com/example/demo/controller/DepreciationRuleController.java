package com.example.demo.controller;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.service.DepreciationRuleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class DepreciationRuleController {

    private final DepreciationRuleService service;

    public DepreciationRuleController(DepreciationRuleService service) {
        this.service = service;
    }

    @PostMapping
    public DepreciationRule create(@RequestBody DepreciationRule rule) {
        return service.save(rule);
    }
}
