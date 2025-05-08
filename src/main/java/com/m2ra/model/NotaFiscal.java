package com.m2ra.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_nota_fiscal")
public class NotaFiscal {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    //TODO: RELACIONAMENTO ONE TO ONE
    @Column(name="id_pedido")
    private Integer idPedido;

    private String xml;

    @Column(name="data_emissao")
    private LocalDateTime dataEmissao;
}
