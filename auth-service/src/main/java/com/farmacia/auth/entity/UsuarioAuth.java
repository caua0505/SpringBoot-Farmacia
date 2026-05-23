package com.farmacia.auth.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios_auth")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, length = 50)
    private String perfil;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(nullable = false)
    private LocalDateTime criadoEm;

    @PrePersist
    public void prePersist() {
        this.ativo = true;
        this.criadoEm = LocalDateTime.now();

        if (this.perfil == null || this.perfil.isBlank()) {
            this.perfil = "USER";
        }
    }
}