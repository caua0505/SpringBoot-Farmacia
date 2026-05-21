package com.farmacia.movimentacao.service;

import com.farmacia.movimentacao.dto.MovimentacaoRequestDTO;
import com.farmacia.movimentacao.dto.MovimentacaoResponseDTO;
import com.farmacia.movimentacao.entity.Movimentacao;
import com.farmacia.movimentacao.repository.MovimentacaoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MovimentacaoService {

    private final MovimentacaoRepository repository;

    public MovimentacaoResponseDTO criar(
            MovimentacaoRequestDTO dto){

        Movimentacao movimentacao = Movimentacao.builder()
                .produtoId(dto.getProdutoId())
                .tipo(dto.getTipo())
                .quantidade(dto.getQuantidade())
                .dataMovimentacao(dto.getDataMovimentacao())
                .build();

        Movimentacao salva =
                repository.save(movimentacao);

        return converter(salva);
    }

    public List<MovimentacaoResponseDTO> listar(){

        return repository.findAll()
                .stream()
                .map(this::converter)
                .toList();
    }

    private MovimentacaoResponseDTO converter(
            Movimentacao movimentacao){

        return MovimentacaoResponseDTO.builder()
                .id(movimentacao.getId())
                .produtoId(movimentacao.getProdutoId())
                .tipo(movimentacao.getTipo())
                .quantidade(movimentacao.getQuantidade())
                .dataMovimentacao(
                        movimentacao.getDataMovimentacao())
                .build();
    }
}