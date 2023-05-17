package com.projeto.salesapiapringboot.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto.salesapiapringboot.dto.VendedorListaDTO;
import com.projeto.salesapiapringboot.projections.VendedorListaProjection;
import com.projeto.salesapiapringboot.services.VendaService;

@SpringBootTest
public class VendaRepositoryTest {

    @Mock
    private VendaRepository vendaRepository;
    
    @Mock
    private VendedorRepository vendedorRepository;

    @InjectMocks
    private VendaService vendaService;

    @Test
    public void testGetVendedoresResumoVendasPeriodo() {
        // Dados de entrada
        LocalDate dataInicial = LocalDate.of(2023, 1, 1);
        LocalDate dataFinal = LocalDate.of(2023, 12, 31);

        // Mock do resultado da consulta
        List<VendedorListaProjection> projections = new ArrayList<>();
        // Adicionar projeções de exemplo à lista

        when(vendaRepository.getVendedoresResumoVendasPeriodo(dataInicial, dataFinal)).thenReturn(projections);

        // Executar o método a ser testado
        List<VendedorListaDTO> vendedores = vendaService.getVendedoresResumoVendasPeriodo(dataInicial, dataFinal);

        // Verificar o resultado
        assertEquals(projections.size(), vendedores.size());
        // Verificar outras condições necessárias nos objetos resultantes, se houver

        // Verificar se o método do repositório foi chamado corretamente
        verify(vendaRepository, times(1)).getVendedoresResumoVendasPeriodo(dataInicial, dataFinal);
    }

}





