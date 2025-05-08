package com.m2ra.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_estoque")
public class Estoque {

    //TODO: VERIFICAR SOBRE ID EMBUTIDO (EMBEDDED ID)

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name="id_produto")
    private Integer idProduto;

    private BigDecimal quantidade;
}
