package com.m2ra.model;

import com.m2ra.model.embedded.Endereco;
import com.m2ra.model.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@ToString
@Table(name="tab_pedido")
public class Pedido {

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

//    @OneToMany
//    private List<ItemPedido> itensPedido = new ArrayList<>();

    @Column(name="data_pedido")
    private LocalDateTime dataPedido;

    @Column(name="data_conclusao")
    private LocalDateTime dataConclusao;

    //TODO: VER RELAÇÃO ONE TO ONE
//    @Column(name="id_nota_fiscal")
//    private Integer idNotaFiscal;

    @Column(name="status_pedido")
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    //TODO: VER NECESSIDADE DA COLUNA
//    @Column(name="valor_total_pedido")
//    private BigDecimal valorTotalPedido;

    @Embedded
    private Endereco enderecoEntrega;

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", dataPedido=" + dataPedido +
                ", dataConclusao=" + dataConclusao +
                ", statusPedido=" + statusPedido +
                ", enderecoEntrega=" + enderecoEntrega +
                '}';
    }
}
