package com.m2ra.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Table(name="tab_produto")
public class Produto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    private String nome;

    private BigDecimal preco;

    private String descricao;
}