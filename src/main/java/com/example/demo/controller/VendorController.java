package com.example.demo.controller;

import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
@CrossOrigin(origins = "*")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    // POST – Create Vendor
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.save(vendor);
    }

    // GET – Get All Vendors
    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.findAll();
    }
}
