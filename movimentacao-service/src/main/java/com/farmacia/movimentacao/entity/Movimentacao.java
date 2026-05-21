package com.farmacia.movimentacao.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="movimentacoes")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long produtoId;

    private String tipo;

    private Integer quantidade;

    private String dataMovimentacao;
}
