package com.farmacia.auth.controller;

import com.farmacia.auth.dto.LoginRequestDTO;
import com.farmacia.auth.dto.LoginResponseDTO;
import com.farmacia.auth.dto.RegisterRequestDTO;
import com.farmacia.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> registrar(
            @Valid @RequestBody RegisterRequestDTO request
    ) {
        LoginResponseDTO response = authService.registrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO request
    ) {
        LoginResponseDTO response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}