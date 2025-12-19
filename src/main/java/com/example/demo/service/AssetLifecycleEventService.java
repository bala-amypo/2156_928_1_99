package com.example.demo.service;

import com.example.demo.entity.AssetLifecycleEvent;
import com.example.demo.repository.AssetLifecycleEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetLifecycleEventService {

    private final AssetLifecycleEventRepository repository;

    public AssetLifecycleEventService(AssetLifecycleEventRepository repository) {
        this.repository = repository;
    }

    public AssetLifecycleEvent save(AssetLifecycleEvent event) {
        return repository.save(event);
    }

    public List<AssetLifecycleEvent> findAll() {
        return repository.findAll();
    }
}
