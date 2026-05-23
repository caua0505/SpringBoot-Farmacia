package com.farmacia.auth.service;

import com.farmacia.auth.dto.LoginRequestDTO;
import com.farmacia.auth.dto.LoginResponseDTO;
import com.farmacia.auth.dto.RegisterRequestDTO;
import com.farmacia.auth.entity.UsuarioAuth;
import com.farmacia.auth.repository.UsuarioAuthRepository;
import com.farmacia.auth.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioAuthRepository usuarioAuthRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponseDTO registrar(RegisterRequestDTO request) {
        if (usuarioAuthRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado");
        }

        UsuarioAuth usuario = UsuarioAuth.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .perfil("USER")
                .ativo(true)
                .build();

        usuarioAuthRepository.save(usuario);

        String token = jwtService.gerarToken(usuario.getEmail());

        return new LoginResponseDTO(
                token,
                "Bearer",
                usuario.getEmail(),
                usuario.getPerfil()
        );
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        UsuarioAuth usuario = usuarioAuthRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        boolean senhaCorreta = passwordEncoder.matches(
                request.getSenha(),
                usuario.getSenha()
        );

        if (!senhaCorreta) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.gerarToken(usuario.getEmail());

        return new LoginResponseDTO(
                token,
                "Bearer",
                usuario.getEmail(),
                usuario.getPerfil()
        );
    }
}