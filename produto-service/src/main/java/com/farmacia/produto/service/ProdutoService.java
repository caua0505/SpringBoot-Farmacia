package com.farmacia.produto.service;

import com.farmacia.produto.dto.ProdutoRequestDTO;
import com.farmacia.produto.dto.ProdutoResponseDTO;
import com.farmacia.produto.entity.Produto;
import com.farmacia.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoResponseDTO criar(ProdutoRequestDTO dto){

        Produto produto = Produto.builder()
                .nome(dto.getNome())
                .categoria(dto.getCategoria())
                .preco(dto.getPreco())
                .quantidade(dto.getQuantidade())
                .validade(dto.getValidade())
                .build();

        Produto salvo = repository.save(produto);

        return converter(salvo);
    }

    public List<ProdutoResponseDTO> listar(){

        return repository.findAll()
                .stream()
                .map(this::converter)
                .toList();
    }

    private ProdutoResponseDTO converter(Produto produto){

        return ProdutoResponseDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .categoria(produto.getCategoria())
                .preco(produto.getPreco())
                .quantidade(produto.getQuantidade())
                .validade(produto.getValidade())
                .build();
    }
}