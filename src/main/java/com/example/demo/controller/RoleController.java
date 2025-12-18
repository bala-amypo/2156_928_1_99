package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Create a new role (ADMIN only - secured later)
    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // Get all roles
    @GetMapping
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
