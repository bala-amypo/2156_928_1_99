package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.service.AssetDisposalService;

@RestController
@RequestMapping("/api/disposals")
public class AssetDisposalController {

    private final AssetDisposalService disposalService;

    public AssetDisposalController(AssetDisposalService disposalService) {
        this.disposalService = disposalService;
    }

    @PostMapping
    public ResponseEntity<AssetDisposal> create(@RequestBody AssetDisposal disposal) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(disposalService.requestDisposal(disposal));
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<AssetDisposal> approve(@PathVariable Long id) {
        return ResponseEntity.ok(disposalService.approveDisposal(id));
    }
}
