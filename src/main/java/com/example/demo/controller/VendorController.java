package com.example.demo.controller;

import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
@CrossOrigin
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    // CREATE Vendor
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.save(vendor);
    }

    // READ Vendors
    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.findAll();
    }
}
