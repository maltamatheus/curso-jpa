package com.m2ra.util;

import com.m2ra.model.Cliente;
import com.m2ra.model.enums.SexoCliente;

public class ExercicioCrudCliente {

    static PersistenciaDeDadosCliente persistenciaDeDadosCliente = new PersistenciaDeDadosCliente();
    public static void main(String[] args) {
        inserindoCliente();
        consultarCliente();
        atualizarCliente();
        removerCliente(10);
    }

    public static void inserindoCliente(){
        Cliente cliente = new Cliente("Matheus Malta de Aguiar", SexoCliente.MASCULINO);
        persistenciaDeDadosCliente.criarCliente(cliente);
    }

    public static void consultarCliente(){
        System.out.println("Consultando cliente de ID = 1");
        System.out.println(persistenciaDeDadosCliente.consultarCliente(1));
        System.out.println("Consultando cliente de ID = 10");
        System.out.println(persistenciaDeDadosCliente.consultarCliente(10));
    }

    public static void atualizarCliente(){
        System.out.println("Atualizando o cliente ID = 2");
        System.out.println("Antes da Atualização = " + persistenciaDeDadosCliente.consultarCliente(2));
        Cliente cliente = new Cliente("Débora Nascimento", SexoCliente.FEMININO);
        persistenciaDeDadosCliente.atualizarCliente(cliente);
        System.out.println("Após a atualização = " + persistenciaDeDadosCliente.consultarCliente(2));
    }

    public static void removerCliente(Integer id){
        System.out.println("Antes da remoção = " + persistenciaDeDadosCliente.consultarCliente(id));
        persistenciaDeDadosCliente.removerCliente(id);
        System.out.println("Após a remoção = " + persistenciaDeDadosCliente.consultarCliente(id));
    }
}
