package com.farmacia.auth.security;

import com.farmacia.auth.entity.UsuarioAuth;
import com.farmacia.auth.repository.UsuarioAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioAuthRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        UsuarioAuth usuario = usuarioRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Usuário não encontrado"
                        )
                );

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .authorities("USER")
                .build();
    }
}