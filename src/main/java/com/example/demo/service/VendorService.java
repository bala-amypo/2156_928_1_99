package com.example.demo.service;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    // CREATE
    public Vendor save(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // READ
    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }
}
