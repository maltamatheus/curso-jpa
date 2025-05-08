package com.m2ra.util;

import com.m2ra.model.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UploadTabelasObjetos {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("curso-jpa");

        Categoria categoria = new Categoria();
        Cliente cliente = new Cliente();
        Estoque estoque = new Estoque();
        ItemPedido itemPedido = new ItemPedido();
        NotaFiscal notaFiscal = new NotaFiscal();
        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        Pedido pedido = new Pedido();
        Produto produto = new Produto();
    }
}
