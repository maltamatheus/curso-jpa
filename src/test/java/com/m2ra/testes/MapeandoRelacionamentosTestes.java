package com.m2ra.testes;

import com.m2ra.model.*;
import com.m2ra.model.embedded.ItemPedidoId;
import com.m2ra.model.enums.SexoCliente;
import com.m2ra.model.enums.StatusPedido;
import com.m2ra.util.EntityManagerTest;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeandoRelacionamentosTestes extends EntityManagerTest {

    @Test
    public void inserirItemPedido(){
        criarCliente();
        Cliente cliente = entityManager.find(Cliente.class,1);

        criarProduto();
        Produto produto = entityManager.find(Produto.class,1);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatusPedido(StatusPedido.AGUARDANDO);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setItemPedidoId(new ItemPedidoId());
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(10);

        entityManager.getTransaction().begin();
        entityManager.merge(pedido);
        entityManager.merge(itemPedido);
        entityManager.getTransaction().commit();
    }

    @Test
    public void criarPedidoComClienteComItemPedidoComProduto(){

        criarPedidoComCliente();

        criarProduto();

        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = entityManager.find(Pedido.class, 1);

        ItemPedidoId itemPedidoId = new ItemPedidoId();

        itemPedidoId.setIdPedido(pedido.getId());
        itemPedidoId.setIdProduto(produto.getId());

        ItemPedido itemPedido = new ItemPedido();

        //Usado no @IdClass
//        itemPedido.setIdPedido(pedido.getId());
//        itemPedido.setIdProduto(produto.getId());

        //Usado no EmbeddedId
        itemPedido.setItemPedidoId(new com.m2ra.model.embedded.ItemPedidoId(pedido.getId(), produto.getId()));

        itemPedido.setQuantidade(10);

        entityManager.getTransaction().begin();
        entityManager.merge(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido itemPedidoIns = entityManager.find(ItemPedido.class, itemPedidoId);

//        System.out.println(itemPedidoIns.getIdPedido() + " - " +
//                           itemPedidoIns.getIdProduto()  + " - " +
//                           itemPedidoIns.getQuantidade());

        System.out.println(itemPedidoIns.getItemPedidoId().getIdPedido()   + " - " +
                           itemPedidoIns.getItemPedidoId().getIdProduto()  + " - " +
                           itemPedidoIns.getQuantidade());

    }

    @Test
    public void criarPedidoComCliente(){

        criarCliente();

        Cliente cliente = entityManager.find(Cliente.class,1);

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);

        pedido.setDataPedido(LocalDateTime.now());

        pedido.setStatusPedido(StatusPedido.AGUARDANDO);

        entityManager.getTransaction().begin();
        pedido = entityManager.merge(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoIns = entityManager.find(Pedido.class,1);

        System.out.println("------ Pedido salvo com sucesso ------");

        System.out.println(pedidoIns.getId()       + " - " +
                           pedidoIns.getCliente()  + " - " +
                           pedidoIns.getDataPedido());
    }

    @Test
    public void criarItemPedidoComProduto(){

        criarProduto();

        Produto produto = entityManager.find(Produto.class,1);

        ItemPedido itemPedido = new ItemPedido();

//        itemPedido.setIdProduto(produto.getId());

        itemPedido.setQuantidade(10);

        entityManager.getTransaction().begin();
        entityManager.merge(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido itemPedidoIns = entityManager.find(ItemPedido.class,1);

//        System.out.println(itemPedidoIns.getIdPedido()   + " - " +
//                           itemPedidoIns.getIdProduto()  + " - " +
//                           itemPedidoIns.getQuantidade() + " - ");
    }
    @Test
    public void criarCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome("Matheus Malta");
        cliente.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteIns = entityManager.find(Cliente.class,1);

        System.out.println(clienteIns);
    }

    @Test
    public void criarProduto(){
        Produto produto = new Produto();

        produto.setNome("iPhone 12 Pro Max");
        produto.setPreco(new BigDecimal(4999));
        produto.setDescricao("Novo iPhone 12 Pro Max");

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoIns = entityManager.find(Produto.class,1);

    }
}
