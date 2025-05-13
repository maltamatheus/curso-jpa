package com.m2ra.model.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemPedidoId implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name="id_pedido")
    private Integer idPedido;

    @EqualsAndHashCode.Include
    @Column(name="id_produto")
    private Integer idProduto;
}
