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

    public MovimentacaoResponseDTO buscarPorId(
            Long id){

        Movimentacao movimentacao =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Movimentação não encontrada"));

        return converter(movimentacao);
    }

    public MovimentacaoResponseDTO atualizar(
            Long id,
            MovimentacaoRequestDTO dto){

        Movimentacao movimentacao =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Movimentação não encontrada"));

        movimentacao.setProdutoId(dto.getProdutoId());
        movimentacao.setTipo(dto.getTipo());
        movimentacao.setQuantidade(dto.getQuantidade());
        movimentacao.setDataMovimentacao(
                dto.getDataMovimentacao());

        Movimentacao atualizada =
                repository.save(movimentacao);

        return converter(atualizada);
    }

    public void deletar(
            Long id){

        Movimentacao movimentacao =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Movimentação não encontrada"));

        repository.delete(movimentacao);
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