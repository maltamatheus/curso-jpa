package com.m2ra.model;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoId implements Serializable {

    @EqualsAndHashCode.Include
    private Integer idPedido;

    @EqualsAndHashCode.Include
    private Integer idProduto;
}
