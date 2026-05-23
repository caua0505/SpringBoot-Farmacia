package com.farmacia.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @GetMapping("/protegido")
    public ResponseEntity<String> rotaProtegida() {
        return ResponseEntity.ok("Acesso liberado com JWT válido!");
    }
}