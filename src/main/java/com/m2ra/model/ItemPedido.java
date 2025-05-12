package com.m2ra.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@IdClass(ItemPedidoId.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_item_pedido")
public class ItemPedido {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @EqualsAndHashCode.Include
//    @Setter(AccessLevel.NONE)
//    private Integer id;

//    @ManyToOne(optional = false)
//    @JoinColumn(name="id_pedido")
//    private Pedido pedido;

//    @ManyToOne(optional = false)
//    @JoinColumn(name="id_produto")
//    private Produto produto;

    @EqualsAndHashCode.Include
    @Id
    @Column(name="id_pedido")
    private Integer idPedido;

    @EqualsAndHashCode.Include
    @Id
    @Column(name="id_produto")
    private Integer idProduto;

    @Column(name="quantidade", nullable = false)
    private Integer quantidade;
}
