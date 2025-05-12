package com.m2ra.testes;

import com.m2ra.model.Pedido;
import com.m2ra.util.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

public class TestesGerais extends EntityManagerTest {

    @Test
    public void testandoCarregamentoEager(){
        Pedido pedido = entityManager.find(Pedido.class,1);

        Assert.assertNotNull(pedido);
    }
}
