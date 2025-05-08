package com.m2ra.model;

import com.m2ra.model.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_pagamento_boleto")
public class PagamentoBoleto {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    //TODO: RELAÇÃO ONE TO MANY
    @Column(name="id_pedido")
    private Integer idPedido;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    @Column(name="codigo_barras")
    private String codigoBarras;
}
