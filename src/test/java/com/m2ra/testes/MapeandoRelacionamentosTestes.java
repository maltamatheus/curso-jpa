package com.m2ra.testes;

import com.m2ra.model.Cliente;
import com.m2ra.model.ItemPedido;
import com.m2ra.model.Pedido;
import com.m2ra.model.Produto;
import com.m2ra.model.enums.SexoCliente;
import com.m2ra.model.enums.StatusPedido;
import com.m2ra.util.EntityManagerTest;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeandoRelacionamentosTestes extends EntityManagerTest {

    @Test
    public void criarPedidoComClienteComItemPedidoComProduto(){

        criarPedidoComCliente();

        criarItemPedidoComProduto();

        ItemPedido itemPedido = entityManager.find(ItemPedido.class,1);

        Pedido pedido = entityManager.find(Pedido.class,1);

        itemPedido.setPedido(pedido);

        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatusPedido(StatusPedido.AGUARDANDO);

        entityManager.getTransaction().begin();
        entityManager.merge(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido itemPedidoIns = entityManager.find(ItemPedido.class,1);

        System.out.println(itemPedidoIns);

//        entityManager.clear();
//
//        Cliente cliente = entityManager.find(Cliente.class,1);
//
//        System.out.println(cliente);
    }

    @Test
    public void criarPedidoComCliente(){

        criarClientePedido();

        Cliente cliente = entityManager.find(Cliente.class,1);

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();
        pedido = entityManager.merge(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

//        Pedido pedidoIns = entityManager.find(Pedido.class,1);

//        System.out.println(pedidoIns);

        System.out.println(pedido);
    }

    @Test
    public void criarItemPedidoComProduto(){

        criarProdutoPedido();

        Produto produto = entityManager.find(Produto.class,1);

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setProduto(produto);

        itemPedido.setQuantidadeItensPedido(new BigDecimal(10));

        entityManager.getTransaction().begin();
        entityManager.merge(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido itemPedidoIns = entityManager.find(ItemPedido.class,1);

        System.out.println(itemPedidoIns);
    }
    @Test
    public void criarClientePedido(){
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
    public void criarProdutoPedido(){
        Produto produto = new Produto();

        produto.setNome("iPhone 12 Pro Max");
        produto.setPreco(new BigDecimal(4999));
        produto.setDescricao("Novo iPhone 12 Pro Max");

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoIns = entityManager.find(Produto.class,1);

        System.out.println(produtoIns);
    }
}
