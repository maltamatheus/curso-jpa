package com.m2ra.util;

import com.m2ra.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenciaDeDadosCliente {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("curso-jpa");
    private EntityManager entityManager = this.entityManagerFactory.createEntityManager();

    //CREATE CLIENTE
    public void criarCliente(Cliente cliente){
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    //READ CLIENTE - Será passado um ID para a leitura do Cliente
    public Cliente consultarCliente(Integer id){
        return entityManager.find(Cliente.class,id);
    }

    //UPDATE CLIENTE
    public Cliente atualizarCliente(Cliente cliente){
        entityManager.getTransaction().begin();
        Cliente cli = entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        return cli;
    }

    //DELETE CLIENTE
    public void removerCliente(Integer id){
        Cliente cliente = consultarCliente(id);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
    }
}
