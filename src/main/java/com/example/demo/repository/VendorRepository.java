package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

    Optional<Vendor> findByName(String name); // NOT vendorName
}
