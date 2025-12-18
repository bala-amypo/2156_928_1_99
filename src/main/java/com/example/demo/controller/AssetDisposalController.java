package com.example.demo.controller;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.repository.AssetDisposalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset-disposals")
public class AssetDisposalController {

    private final AssetDisposalRepository repository;

    public AssetDisposalController(AssetDisposalRepository repository) {
        this.repository = repository;
    }

    // Request or approve asset disposal
    @PostMapping
    public AssetDisposal createDisposal(@RequestBody AssetDisposal disposal) {
        return repository.save(disposal);
    }

    // Get all disposal records
    @GetMapping
    public List<AssetDisposal> getAllDisposals() {
        return repository.findAll();
    }
}
