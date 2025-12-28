package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user,
                                      @RequestParam String role) {
        return ResponseEntity.ok(userService.registerUser(user, role));
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.get("email"),
                        request.get("password")
                )
        );

        User user = userService.findByEmail(request.get("email"));

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getId(),
                user.getRolesAsStringSet()
        );

        return ResponseEntity.ok(Map.of("token", token));
    }
}
