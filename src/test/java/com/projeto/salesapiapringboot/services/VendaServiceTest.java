package com.projeto.salesapiapringboot.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.projeto.salesapiapringboot.dto.VendaDTO;
import com.projeto.salesapiapringboot.dto.VendedorListaDTO;
import com.projeto.salesapiapringboot.models.Venda;
import com.projeto.salesapiapringboot.models.Vendedor;
import com.projeto.salesapiapringboot.projections.VendedorListaProjection;
import com.projeto.salesapiapringboot.repositories.VendaRepository;
import com.projeto.salesapiapringboot.repositories.VendedorRepository;

public class VendaServiceTest {

    @Mock
    private VendaRepository vendaRepository;
    
    @Mock
    private VendedorRepository vendedorRepository;
    
    @InjectMocks
    private VendaService vendaService;
    
    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testFindAll() {
        // Mocking the repository's response
        Vendedor vendedor = new Vendedor();
        vendedor.setId(1L);
        Venda venda1 = new Venda(/* data, valor, vendedor */);
        venda1.setVendedor(vendedor);
        Venda venda2 = new Venda(/* data, valor, vendedor */);
        venda2.setVendedor(vendedor);
        List<Venda> vendas = Arrays.asList(venda1, venda2);
        when(vendaRepository.findAll()).thenReturn(vendas);

        // Calling the service method
        List<VendaDTO> result = vendaService.findAll();

        // Verifying the result
        assertEquals(2, result.size());
        // Additional assertions can be performed to validate the correctness of the mapping

        // Verifying that the repository's findAll method was called
        verify(vendaRepository, times(1)).findAll();
    }

    @Test
    public void testCriarVenda() {
        // Mocking the repository's response
        VendaDTO vendaDTO = new VendaDTO(/* venda data, venda valor, vendedor ID */);
        Vendedor vendedor = new Vendedor(/* vendedor data */);
        when(vendedorRepository.findById(vendaDTO.getVendedorId())).thenReturn(Optional.of(vendedor));
        when(vendaRepository.save(any(Venda.class))).thenAnswer(invocation -> invocation.getArgument(0));
        
        // Calling the service method
        Venda result = vendaService.criarVenda(vendaDTO);
        
        // Verifying the result
        assertEquals(vendaDTO.getDataVenda(), result.getDataVenda());
        assertEquals(vendaDTO.getValor(), result.getValor());
        assertEquals(vendedor, result.getVendedor());
        
        // Verifying that the repository's findById and save methods were called
        verify(vendedorRepository, times(1)).findById(vendaDTO.getVendedorId());
        verify(vendaRepository, times(1)).save(any(Venda.class));
    }
    
    @Test
    public void testGetVendedoresResumoVendasPeriodo() {
        // Mocking the repository's response
        LocalDate dataInicial = LocalDate.of(2023, 1, 1);
        LocalDate dataFinal = LocalDate.of(2023, 12, 31);
        VendedorListaProjection projection1 = mock(VendedorListaProjection.class);
        VendedorListaProjection projection2 = mock(VendedorListaProjection.class);
        List<VendedorListaProjection> projections = Arrays.asList(projection1, projection2);
        when(vendaRepository.getVendedoresResumoVendasPeriodo(dataInicial, dataFinal)).thenReturn(projections);
        
        // Calling the service method
        List<VendedorListaDTO> result = vendaService.getVendedoresResumoVendasPeriodo(dataInicial, dataFinal);
        
        // Verifying the result
        assertEquals(2, result.size());
        // Additional assertions can be performed to validate the correctness of the mapping
        
        // Verifying that the repository's getVendedoresResumoVendasPeriodo method was called
        verify(vendaRepository, times(1)).getVendedoresResumoVendasPeriodo(dataInicial, dataFinal);
    }
}
