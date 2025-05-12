package com.m2ra.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "categoria")
    private List<Categoria> subCategorias;

    @ManyToMany
    @JoinTable(name = "tab_categoria_produto"
              ,joinColumns = @JoinColumn(name="id_categoria")
              ,inverseJoinColumns = @JoinColumn(name="id_produto"))
    private List<Produto> produtos;
}
