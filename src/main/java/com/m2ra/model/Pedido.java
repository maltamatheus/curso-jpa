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
@Table(name="tab_pedido")
public class Pedido {

    @Id
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

//    @OneToMany(mappedBy = "pedido")
//    private List<ItemPedido> itensPedido;

    @Column(name="data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    @Column(name="data_conclusao")
    private LocalDateTime dataConclusao;

    @OneToOne(mappedBy = "pedido")
    private NotaFiscal notaFiscal;

    @Column(name="status_pedido", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    @Embedded
    private Endereco enderecoEntrega;

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamentoCartao;

}
