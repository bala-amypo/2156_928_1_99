package com.example.demo.controller;

import com.example.demo.entity.AssetLifecycleEvent;
import com.example.demo.repository.AssetLifecycleEventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset-events")
public class AssetLifecycleEventController {

    private final AssetLifecycleEventRepository repository;

    public AssetLifecycleEventController(AssetLifecycleEventRepository repository) {
        this.repository = repository;
    }

    // Log a lifecycle event (maintenance / assignment / disposal request)
    @PostMapping
    public AssetLifecycleEvent createEvent(@RequestBody AssetLifecycleEvent event) {
        return repository.save(event);
    }

    // Get all lifecycle events
    @GetMapping
    public List<AssetLifecycleEvent> getAllEvents() {
        return repository.findAll();
    }
}
