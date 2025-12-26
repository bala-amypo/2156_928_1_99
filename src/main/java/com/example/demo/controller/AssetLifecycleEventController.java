package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetLifecycleEvent;
import com.example.demo.repository.AssetLifecycleEventRepository;
import com.example.demo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AssetLifecycleEventController {

    @Autowired private AssetLifecycleEventRepository eventRepository;
    @Autowired private AssetRepository assetRepository;

    @PostMapping("/{assetId}")
    public ResponseEntity<AssetLifecycleEvent> logEvent(
            @PathVariable Long assetId,
            @RequestBody AssetLifecycleEvent event) {

        if (event.getEventDate().isAfter(LocalDate.now())) {
            return ResponseEntity.badRequest().build();
        }

        Asset asset = assetRepository.findById(assetId).orElseThrow();
        event.setAsset(asset);

        return ResponseEntity.ok(eventRepository.save(event));
    }

    @GetMapping("/asset/{assetId}")
    public ResponseEntity<List<AssetLifecycleEvent>> getEvents(@PathVariable Long assetId) {
        return ResponseEntity.ok(
                eventRepository.findByAssetIdOrderByEventDateDesc(assetId));
    }
}
