package com.farmacia.movimentacao.dto;

import lombok.Data;
@Data
public class MovimentacaoRequestDTO {
    private Long produtoId;

    private String tipo;

    private Integer quantidade;

    private String dataMovimentacao;
}
