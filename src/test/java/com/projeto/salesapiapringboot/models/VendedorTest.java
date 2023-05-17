package com.projeto.salesapiapringboot.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VendedorTest {

    @Test
    public void testGetId() {
        Long id = 1L;
        String nome = "João";
        Vendedor vendedor = new Vendedor(id, nome);

        Assertions.assertEquals(id, vendedor.getId());
    }

    @Test
    public void testGetNome() {
        Long id = 1L;
        String nome = "João";
        Vendedor vendedor = new Vendedor(id, nome);

        Assertions.assertEquals(nome, vendedor.getNome());
    }

    @Test
    public void testSetId() {
        Long id = 1L;
        //String nome = "João";
        Vendedor vendedor = new Vendedor();
        vendedor.setId(id);

        Assertions.assertEquals(id, vendedor.getId());
    }

    @Test
    public void testSetNome() {
        //Long id = 1L;
        String nome = "João";
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(nome);

        Assertions.assertEquals(nome, vendedor.getNome());
    }

    @Test
    public void testEquals() {
        Long id = 1L;
        String nome = "João";
        Vendedor vendedor1 = new Vendedor(id, nome);
        Vendedor vendedor2 = new Vendedor(id, nome);

        Assertions.assertEquals(vendedor1, vendedor2);
    }

    @Test
    public void testHashCode() {
        Long id = 1L;
        String nome = "João";
        Vendedor vendedor1 = new Vendedor(id, nome);
        Vendedor vendedor2 = new Vendedor(id, nome);

        Assertions.assertEquals(vendedor1.hashCode(), vendedor2.hashCode());
    }
}