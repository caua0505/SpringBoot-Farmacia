package com.farmacia.produto.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoResponseDTO {

    private Long id;

    private String nome;

    private String categoria;

    private Double preco;

    private Integer quantidade;

    private String validade;
}