package com.farmacia.movimentacao.controller;

import com.farmacia.movimentacao.dto.MovimentacaoResponseDTO;
import com.farmacia.movimentacao.dto.MovimentacaoRequestDTO;
import com.farmacia.movimentacao.service.MovimentacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
@RequiredArgsConstructor

public class MovimentacaoController {

    private final MovimentacaoService service;

    @PostMapping
    public MovimentacaoResponseDTO criar(
            @RequestBody MovimentacaoRequestDTO dto){

        return service.criar(dto);
    }

    @GetMapping
    public List<MovimentacaoResponseDTO> listar(){

        return service.listar();
    }
}