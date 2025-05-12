package com.m2ra.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_nota_fiscal")
public class NotaFiscal {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name="id_pedido")
    private Pedido pedido;

    @Column(name="nota_fiscal", nullable = false)
    private String xml;

    @Column(name="data_emissao", nullable = false)
    private LocalDateTime dataEmissao;
}
