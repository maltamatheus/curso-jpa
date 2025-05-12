package com.m2ra.model;

import com.m2ra.model.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_pagamento_boleto")
public class PagamentoBoleto {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name="id_pedido")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    @Column(name="codigo_barras",nullable = false)
    private String codigoBarras;
}
