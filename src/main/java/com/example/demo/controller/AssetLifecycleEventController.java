package com.example.demo.controller;

import com.example.demo.entity.AssetLifecycleEvent;
import com.example.demo.service.AssetLifecycleEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(name = "Asset Lifecycle Events")
public class AssetLifecycleEventController {

    private final AssetLifecycleEventService service;

    public AssetLifecycleEventController(AssetLifecycleEventService service) {
        this.service = service;
    }

    // POST /api/events/{assetId}
    @PostMapping("/{assetId}")
    public ResponseEntity<AssetLifecycleEvent> logEvent(
            @PathVariable Long assetId,
            @RequestBody AssetLifecycleEvent event) {
        return ResponseEntity.ok(service.logEvent(assetId, event));
    }

    // GET /api/events/asset/{assetId}
    @GetMapping("/asset/{assetId}")
    public ResponseEntity<List<AssetLifecycleEvent>> getEventsByAsset(
            @PathVariable Long assetId) {
        return ResponseEntity.ok(service.getEventsByAsset(assetId));
    }
}
