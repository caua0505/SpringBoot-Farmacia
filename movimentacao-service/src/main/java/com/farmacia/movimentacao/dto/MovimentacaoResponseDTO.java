package com.farmacia.movimentacao.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class MovimentacaoResponseDTO {

    private Long id;

    private Long produtoId;

    private String tipo;

    private Integer quantidade;

    private String dataMovimentacao;
}
