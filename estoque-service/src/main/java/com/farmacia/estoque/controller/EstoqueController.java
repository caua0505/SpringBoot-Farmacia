package com.farmacia.estoque_service.controller;

import com.farmacia.estoque_service.dto.EstoqueRequestDTO;
import com.farmacia.estoque_service.dto.EstoqueResponseDTO;
import com.farmacia.estoque_service.service.EstoqueService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoques")
@RequiredArgsConstructor
public class EstoqueController {

    private final EstoqueService estoqueService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstoqueResponseDTO criar(
            @RequestBody @Valid EstoqueRequestDTO dto
    ) {

        return estoqueService.criar(dto);
    }

    @GetMapping
    public List<EstoqueResponseDTO> listarTodos() {

        return estoqueService.listarTodos();
    }

    @GetMapping("/{id}")
    public EstoqueResponseDTO buscarPorId(
            @PathVariable Long id
    ) {

        return estoqueService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public EstoqueResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody @Valid EstoqueRequestDTO dto
    ) {

        return estoqueService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(
            @PathVariable Long id
    ) {

        estoqueService.deletar(id);
    }
}
