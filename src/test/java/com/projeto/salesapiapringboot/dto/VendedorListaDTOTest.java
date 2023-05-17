package com.projeto.salesapiapringboot.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.projeto.salesapiapringboot.projections.VendedorListaProjection;

public class VendedorListaDTOTest {

    @Test
    public void testGettersAndSetters() {
        // Criação de uma instância de VendedorListaDTO
        VendedorListaDTO vendedor = new VendedorListaDTO();

        // Definição dos valores dos atributos
        vendedor.setVendedorNome("João");
        vendedor.setTotalVendas(100);
        vendedor.setMediaDiariaVendas(10.5);

        // Verificação dos valores utilizando os métodos getters
        Assertions.assertEquals("João", vendedor.getVendedorNome());
        Assertions.assertEquals(100, vendedor.getTotalVendas());
        Assertions.assertEquals(10.5, vendedor.getMediaDiariaVendas());
    }

    @Test
    public void testConstructorWithArguments() {
        // Criação de uma instância de VendedorListaDTO utilizando o construtor com argumentos
        VendedorListaDTO vendedor = new VendedorListaDTO("Maria", 50, 5.25);

        // Verificação dos valores utilizando os métodos getters
        Assertions.assertEquals("Maria", vendedor.getVendedorNome());
        Assertions.assertEquals(50, vendedor.getTotalVendas());
        Assertions.assertEquals(5.25, vendedor.getMediaDiariaVendas());
    }

    @Test
    public void testConstructorWithProjection() {
        // Criação de uma instância de VendedorListaProjection simulada
        VendedorListaProjection projection = new VendedorListaProjection() {
            @Override
            public String getVendedorNome() {
                return "José";
            }

            @Override
            public Integer getTotalVendas() {
                return 75;
            }

            @Override
            public Double getMediaDiariaVendas() {
                return 7.5;
            }
        };

        // Criação de uma instância de VendedorListaDTO utilizando o construtor com projeção
        VendedorListaDTO vendedor = new VendedorListaDTO(projection);

        // Verificação dos valores utilizando os métodos getters
        Assertions.assertEquals("José", vendedor.getVendedorNome());
        Assertions.assertEquals(75, vendedor.getTotalVendas());
        Assertions.assertEquals(7.5, vendedor.getMediaDiariaVendas());
    }
}