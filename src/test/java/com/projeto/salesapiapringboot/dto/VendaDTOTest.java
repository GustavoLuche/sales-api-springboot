package com.projeto.salesapiapringboot.dto;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.projeto.salesapiapringboot.models.Venda;
import com.projeto.salesapiapringboot.models.Vendedor;

public class VendaDTOTest {

    @Test
    public void testConstructorWithEntity() {
        // Criação de uma entidade Venda para teste
        Venda venda = new Venda();
        venda.setId(1L);
        venda.setDataVenda(LocalDate.now());
        venda.setValor(100.0);
        Vendedor vendedor = new Vendedor();
        vendedor.setId(2L);
        vendedor.setNome("João");
        venda.setVendedor(vendedor);

        // Criação de um objeto VendaDTO utilizando o construtor com a entidade Venda
        VendaDTO vendaDTO = new VendaDTO(venda);

        // Verificação dos valores do VendaDTO com base na entidade Venda
        Assertions.assertEquals(1L, vendaDTO.getId());
        Assertions.assertEquals(LocalDate.now(), vendaDTO.getDataVenda());
        Assertions.assertEquals(100.0, vendaDTO.getValor());
        Assertions.assertEquals(2L, vendaDTO.getVendedorId());
        Assertions.assertEquals("João", vendaDTO.getVendedorNome());
    }
}