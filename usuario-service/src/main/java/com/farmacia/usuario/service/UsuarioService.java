package com.farmacia.usuario_service.service;

import com.farmacia.usuario_service.dto.UsuarioRequestDTO;
import com.farmacia.usuario_service.dto.UsuarioResponseDTO;
import com.farmacia.usuario_service.entity.Usuario;
import com.farmacia.usuario_service.exception.BusinessException;
import com.farmacia.usuario_service.exception.ResourceNotFoundException;
import com.farmacia.usuario_service.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {

        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new BusinessException(
                    "Email já cadastrado");
        }

        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .build();

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return converterParaDTO(usuarioSalvo);
    }

    public List<UsuarioResponseDTO> listarTodos() {

        return usuarioRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuário não encontrado"));

        return converterParaDTO(usuario);
    }

    public UsuarioResponseDTO atualizar(
            Long id,
            UsuarioRequestDTO dto
    ) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuário não encontrado"));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        if (dto.getSenha() != null &&
                !dto.getSenha().isBlank()) {

            usuario.setSenha(
                    passwordEncoder.encode(dto.getSenha())
            );
        }

        Usuario usuarioAtualizado =
                usuarioRepository.save(usuario);

        return converterParaDTO(usuarioAtualizado);
    }

    public void deletar(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuário não encontrado"));

        usuarioRepository.delete(usuario);
    }

    private UsuarioResponseDTO converterParaDTO(
            Usuario usuario
    ) {

        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .build();
    }
}
