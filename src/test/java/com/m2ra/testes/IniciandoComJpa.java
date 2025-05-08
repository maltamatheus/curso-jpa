package com.m2ra.testes;

import com.m2ra.model.Produto;
import com.m2ra.util.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class IniciandoComJpa extends EntityManagerTest {

    @Test
    public void atualizandoComMergeUsandoIdAutomatico(){
        this.inserindoComMergeUsandoIdAutomatico();
        Produto produto = entityManager.find(Produto.class,1);

        produto.setNome(produto.getDescricao());
        produto.setDescricao("Ventilador Arno");

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();
    }

    @Test
    public void inserindoComMergeUsandoIdAutomatico(){
        Produto produto = new Produto();

        produto.setNome("Ventilador Arno");
        produto.setDescricao("Ventilador de Chão 40cm Silencioso");
        produto.setPreco(new BigDecimal(299));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class,1);
        System.out.println(produtoVerificacao);
    }

    @Test
    public void inserindoComMerge(){
        Produto produto = new Produto();

//        produto.setId(5);
        produto.setNome("Óculos de sol");
        produto.setDescricao("Meu novo óculos de sol");
        produto.setPreco(new BigDecimal(299));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class,5);

        Assert.assertEquals("Óculos de sol", produtoVerificacao.getNome());

    }

    @Test
    public void atualizandoObjetoGerenciado(){
        Produto produto = entityManager.find(Produto.class,3);
        produto.setDescricao("Conheça o novo Apple Smart Watch XPTO");

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificado = entityManager.find(Produto.class,3);

        Assert.assertEquals("Conheça o novo Apple Smart Watch XPTO"
                ,produtoVerificado.getDescricao());
    }

    @Test
    public void atualizandoObjeto(){

        Produto produto = new Produto();

//        produto.setId(2);
        produto.setNome("IPhone 13");
        produto.setDescricao("Novo IPhone 13");
        produto.setPreco(new BigDecimal(9999));

        Produto produtoAntes = entityManager.find(Produto.class,2);

        System.out.println("Produto Antes >>> " + produtoAntes);

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class,2);

        System.out.println(produtoVerificacao);

        Assert.assertEquals("IPhone 13", produtoVerificacao.getNome());
    }

    @Test
    public void testeUsandoOFlush(){
        Produto p1 = new Produto();
        Produto p2 = new Produto();
        Produto p3 = new Produto();

//        p1.setId(10);
//        p2.setId(11);
//        p3.setId(12);

        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        System.out.println(entityManager.getProperties());

        Produto produto = entityManager.find(Produto.class,12);

        System.out.println(produto);

    }

    @Test
    public void removendoObjetos(){
        //O registro 3 foi inserido através do script
        Produto produto = entityManager.find(Produto.class,3);

        System.out.println("Produto a ser removido: " + produto.getNome());

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class,3);

        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void inserindoOPrimeiroObjeto(){
        Produto produto = new Produto();

//        produto.setId(2);
        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definição para suas fotos");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        /* A chamada do método clear é necessária pois, caso contrário, o entityManager
         * irá retornar o objeto salvo na memória do próprio EntityManager, ou seja,
         * assim a instrução find irá retornar o objeto do banco de dados.
         */
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class,2);

        Assert.assertNotNull(produtoVerificacao);

    }


    @Test
    public void ConsultandoRegistroPorId(){
        Produto produto = entityManager.find(Produto.class,1);

        System.out.println(produto);

        Assert.assertNotNull(produto);
    }

    @Test
    public void abrirEFecharTransacao(){

        Produto produto = new Produto();

        entityManager.getTransaction().begin();

        entityManager.persist(produto);
        entityManager.merge(produto);
        entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }
}
