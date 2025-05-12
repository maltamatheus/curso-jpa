package com.m2ra.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_estoque")
public class Estoque {

    //TODO: VERIFICAR SOBRE ID EMBUTIDO (EMBEDDED ID)

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @OneToOne
    @JoinColumn(name="id_produto")
    private Produto produto;

    private BigDecimal quantidade;
}
