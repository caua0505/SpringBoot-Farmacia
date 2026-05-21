package com.farmacia.produto.controller;

import com.farmacia.produto.dto.ProdutoRequestDTO;
import com.farmacia.produto.dto.ProdutoResponseDTO;
import com.farmacia.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor

public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ProdutoResponseDTO criar(
            @RequestBody ProdutoRequestDTO dto){

        return service.criar(dto);
    }

    @GetMapping
    public List<ProdutoResponseDTO> listar(){

        return service.listar();
    }
}