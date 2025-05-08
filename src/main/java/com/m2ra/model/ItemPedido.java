package com.m2ra.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produto produto;

//    @Column(name="preco_produto")
//    private BigDecimal precoProduto;

    @Column(name="quantidade_itens_pedido")
    private BigDecimal quantidadeItensPedido;
}
