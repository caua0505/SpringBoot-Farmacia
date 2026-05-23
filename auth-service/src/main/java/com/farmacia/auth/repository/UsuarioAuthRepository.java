package com.farmacia.auth.repository;

import com.farmacia.auth.entity.UsuarioAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioAuthRepository extends JpaRepository<UsuarioAuth, Long> {

    Optional<UsuarioAuth> findByEmail(String email);

    boolean existsByEmail(String email);
}