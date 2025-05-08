package com.m2ra.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    private Integer id;

    private String nome;

    //TODO: VER SOBRE AUTO RELACIONAMENTO
    @Column(name="id_categoria_pai")
    private Integer idCategoriaPai;
}
