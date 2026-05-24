package com.farmacia.estoque_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueResponseDTO {

    private Long id;

    private Long produtoId;

    private Integer quantidade;
}
