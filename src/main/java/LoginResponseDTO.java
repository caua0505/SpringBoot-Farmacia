package com.farmacia.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {

    private String token;
    private String tipo;
    private String email;
    private String perfil;
}