package com.m2ra.model;

import com.m2ra.model.embedded.ItemPedidoId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
//@IdClass(ItemPedidoId.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_item_pedido")
public class ItemPedido {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @EqualsAndHashCode.Include
//    @Setter(AccessLevel.NONE)
//    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_pedido")
    @MapsId("idPedido")
    private Pedido pedido;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_produto")
    @MapsId("idProduto")
    private Produto produto;

    //Usado no modo @IdClass
//    @EqualsAndHashCode.Include
//    @Id
//    @Column(name="id_pedido")
//    private Integer idPedido;
//
//    @EqualsAndHashCode.Include
//    @Id
//    @Column(name="id_produto")
//    private Integer idProduto;

    @EmbeddedId
    private ItemPedidoId itemPedidoId;

    @Column(name="quantidade", nullable = false)
    private Integer quantidade;
}
