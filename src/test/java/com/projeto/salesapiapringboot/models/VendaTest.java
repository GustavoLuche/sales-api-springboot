package com.projeto.salesapiapringboot.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class VendaTest {

    @Test
    public void testSettersAndGetters() {
        // Cria uma venda de exemplo
        Venda venda = new Venda();

        // Define os valores usando os setters
        Long id = 1L;
        LocalDate dataVenda = LocalDate.of(2023, 1, 1);
        Double valor = 100.0;
        Vendedor vendedor = new Vendedor();
        venda.setId(id);
        venda.setDataVenda(dataVenda);
        venda.setValor(valor);
        venda.setVendedor(vendedor);

        // Verifica se os valores estão corretos usando os getters
        Assertions.assertEquals(id, venda.getId());
        Assertions.assertEquals(dataVenda, venda.getDataVenda());
        Assertions.assertEquals(valor, venda.getValor());
        Assertions.assertEquals(vendedor, venda.getVendedor());
    }

    @Test
    public void testConstructorWithParameters() {
        Long id = 1L;
        LocalDate dataVenda = LocalDate.of(2023, 1, 1);
        Double valor = 100.0;
        Vendedor vendedor = new Vendedor();

        Venda venda = new Venda(id, dataVenda, valor, vendedor);

        Assertions.assertEquals(id, venda.getId());
        Assertions.assertEquals(dataVenda, venda.getDataVenda());
        Assertions.assertEquals(valor, venda.getValor());
        Assertions.assertEquals(vendedor, venda.getVendedor());
    }

    @Test
    public void testEqualsAndHashCode() {
        // Cria duas vendas com o mesmo ID
        Long id = 1L;
        Venda venda1 = new Venda();
        venda1.setId(id);
        Venda venda2 = new Venda();
        venda2.setId(id);

        // Verifica se as vendas são consideradas iguais e têm o mesmo hash code
        Assertions.assertEquals(venda1, venda2);
        Assertions.assertEquals(venda1.hashCode(), venda2.hashCode());
    }

    @Test
    public void testNotEquals() {
        // Cria duas vendas com IDs diferentes
        Venda venda1 = new Venda();
        venda1.setId(1L);
        Venda venda2 = new Venda();
        venda2.setId(2L);

        // Verifica se as vendas são consideradas diferentes
        Assertions.assertNotEquals(venda1, venda2);
    }
}
