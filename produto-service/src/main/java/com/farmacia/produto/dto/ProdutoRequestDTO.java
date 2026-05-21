package com.farmacia.produto.dto;

import lombok.Data;

@Data
public class ProdutoRequestDTO {

    private String nome;

    private String categoria;

    private Double preco;

    private Integer quantidade;

    private String validade;
}