package com.farmacia.estoque.service;

import com.farmacia.estoque.dto.EstoqueRequestDTO;
import com.farmacia.estoque.dto.EstoqueResponseDTO;
import com.farmacia.estoque.entity.Estoque;
import com.farmacia.estoque.exception.BusinessException;
import com.farmacia.estoque.exception.ResourceNotFoundException;
import com.farmacia.estoque.repository.EstoqueRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public EstoqueResponseDTO criar(EstoqueRequestDTO dto) {

        if (estoqueRepository.existsByProdutoId(dto.getProdutoId())) {
            throw new BusinessException(
                    "Já existe estoque para este produto");
        }

        Estoque estoque = Estoque.builder()
                .produtoId(dto.getProdutoId())
                .quantidade(dto.getQuantidade())
                .build();

        Estoque estoqueSalvo = estoqueRepository.save(estoque);

        return converterParaDTO(estoqueSalvo);
    }

    public List<EstoqueResponseDTO> listarTodos() {

        return estoqueRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public EstoqueResponseDTO buscarPorId(Long id) {

        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Estoque não encontrado"));

        return converterParaDTO(estoque);
    }

    public EstoqueResponseDTO atualizar(
            Long id,
            EstoqueRequestDTO dto
    ) {

        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Estoque não encontrado"));

        estoque.setQuantidade(dto.getQuantidade());

        Estoque estoqueAtualizado = estoqueRepository.save(estoque);

        return converterParaDTO(estoqueAtualizado);
    }

    public void deletar(Long id) {

        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Estoque não encontrado"));

        estoqueRepository.delete(estoque);
    }

    private EstoqueResponseDTO converterParaDTO(
            Estoque estoque
    ) {

        return EstoqueResponseDTO.builder()
                .id(estoque.getId())
                .produtoId(estoque.getProdutoId())
                .quantidade(estoque.getQuantidade())
                .build();
    }
}