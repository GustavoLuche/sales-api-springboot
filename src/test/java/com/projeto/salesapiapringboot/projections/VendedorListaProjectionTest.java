package com.projeto.salesapiapringboot.projections;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VendedorListaProjectionTest {

    @Test
    public void testGetVendedorNome() {
        VendedorListaProjection projection = new VendedorListaProjectionImpl("John Doe", 10, 2.5);
        assertEquals("John Doe", projection.getVendedorNome());
    }

    @Test
    public void testGetTotalVendas() {
        VendedorListaProjection projection = new VendedorListaProjectionImpl("John Doe", 10, 2.5);
        assertEquals(10, projection.getTotalVendas());
    }

    @Test
    public void testGetMediaDiariaVendas() {
        VendedorListaProjection projection = new VendedorListaProjectionImpl("John Doe", 10, 2.5);
        assertEquals(2.5, projection.getMediaDiariaVendas(), 0.01); // Delta of 0.01 for double comparison
    }

    // Implementação de exemplo de VendedorListaProjection para testes
    private static class VendedorListaProjectionImpl implements VendedorListaProjection {
        private String vendedorNome;
        private Integer totalVendas;
        private Double mediaDiariaVendas;

        public VendedorListaProjectionImpl(String vendedorNome, Integer totalVendas, Double mediaDiariaVendas) {
            this.vendedorNome = vendedorNome;
            this.totalVendas = totalVendas;
            this.mediaDiariaVendas = mediaDiariaVendas;
        }

        @Override
        public String getVendedorNome() {
            return vendedorNome;
        }

        @Override
        public Integer getTotalVendas() {
            return totalVendas;
        }

        @Override
        public Double getMediaDiariaVendas() {
            return mediaDiariaVendas;
        }
    }
}
