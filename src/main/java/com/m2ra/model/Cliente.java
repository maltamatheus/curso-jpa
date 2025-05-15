package com.m2ra.model;

import com.m2ra.model.enums.SexoCliente;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tab_cliente")
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column
    private Integer id;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="sexo_cliente", nullable = false)
    @Enumerated(EnumType.STRING)
    private SexoCliente sexo;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    public Cliente(String nome, SexoCliente sexoCliente){
        this.nome = nome;
        this.sexo = sexoCliente;
    }

    public Cliente(String nome, SexoCliente sexoCliente, List<Pedido> pedidos){
        this.nome = nome;
        this.sexo = sexoCliente;
        this.pedidos = pedidos;
    }

    public Cliente(){}

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
//                ", pedidos=" + pedidos +
                '}';
    }
}
