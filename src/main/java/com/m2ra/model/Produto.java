package com.m2ra.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
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

    @ManyToMany(mappedBy = "produtos")
    private List<Categoria> categorias;

    @ElementCollection
    @CollectionTable(name = "tab_tags_produto"
                    ,joinColumns = @JoinColumn(name="id_produto"))
    @Column(name="tag_produto")
    private List<String> tags;
}