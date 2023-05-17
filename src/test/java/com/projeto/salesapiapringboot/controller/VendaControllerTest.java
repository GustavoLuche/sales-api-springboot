package com.projeto.salesapiapringboot.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.projeto.salesapiapringboot.dto.VendaDTO;
import com.projeto.salesapiapringboot.dto.VendedorListaDTO;
import com.projeto.salesapiapringboot.models.Venda;
import com.projeto.salesapiapringboot.services.VendaService;

@SpringJUnitConfig
@WebMvcTest(VendaController.class)
public class VendaControllerTest {

    @MockBean
    private VendaService vendaService;

    @InjectMocks
    private VendaController vendaController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFindAll() throws Exception {
        // Dados de exemplo
        VendaDTO venda1 = new VendaDTO();
        venda1.setId(1L);
        venda1.setValor(100.0);

        VendaDTO venda2 = new VendaDTO();
        venda2.setId(2L);
        venda2.setValor(200.0);

        List<VendaDTO> vendas = Arrays.asList(venda1, venda2);

        // Mock do serviço
        when(vendaService.findAll()).thenReturn(vendas);

        // Executa a requisição GET /vendas
        mockMvc.perform(get("/vendas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].valor", is(100.0)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].valor", is(200.0)));

        // Verifica se o método do serviço foi chamado corretamente
        verify(vendaService, times(1)).findAll();
        verifyNoMoreInteractions(vendaService);
    }

    @Test
    public void testCriarVenda() {
        // Dados de exemplo para a venda
        VendaDTO vendaDTO = new VendaDTO();
        vendaDTO.setVendedorId(1L);
        vendaDTO.setDataVenda(LocalDate.now());
        vendaDTO.setValor(100.0);

        // Mock do VendaService
        VendaService vendaService = mock(VendaService.class);
        Venda vendaCriada = new Venda(vendaDTO.getDataVenda(), vendaDTO.getValor(), null);
        when(vendaService.criarVenda(vendaDTO)).thenReturn(vendaCriada);

        // Criar o controlador e chamar o método de teste
        VendaController vendaController = new VendaController(vendaService);
        @SuppressWarnings("unchecked")
        ResponseEntity<Venda> response = (ResponseEntity<Venda>) vendaController.criarVenda(vendaDTO);

        // Verificar se o serviço foi chamado com os argumentos corretos
        ArgumentCaptor<VendaDTO> argumentCaptor = ArgumentCaptor.forClass(VendaDTO.class);
        verify(vendaService).criarVenda(argumentCaptor.capture());
        VendaDTO argument = argumentCaptor.getValue();
        assertEquals(vendaDTO.getVendedorId(), argument.getVendedorId());
        assertEquals(vendaDTO.getDataVenda(), argument.getDataVenda());
        assertEquals(vendaDTO.getValor(), argument.getValor());

        // Verificar se a resposta HTTP tem o código de status correto e o objeto Venda
        // correto no corpo
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(vendaCriada, response.getBody());
    }

    @Test
    public void testCriarVenda_InvalidVendedor() {
        // Dados de exemplo para a venda com vendedor inválido
        VendaDTO vendaDTO = new VendaDTO();
        vendaDTO.setVendedorId(999L); // ID inválido
        vendaDTO.setDataVenda(LocalDate.now());
        vendaDTO.setValor(100.0);

        // Mock do VendaService
        VendaService vendaService = mock(VendaService.class);
        when(vendaService.criarVenda(vendaDTO))
                .thenThrow(new IllegalArgumentException("Vendedor com o ID especificado não encontrado"));

        // Criar o controlador e chamar o método de teste
        VendaController vendaController = new VendaController(vendaService);
        ResponseEntity<?> response = vendaController.criarVenda(vendaDTO);

        // Verificar se a resposta HTTP tem o código de status correto
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testGetVendedoresResumoVendasPeriodo() throws Exception {
        LocalDate dataInicial = LocalDate.of(2023, 1, 1);
        LocalDate dataFinal = LocalDate.of(2023, 12, 31);

        List<VendedorListaDTO> vendedores = new ArrayList<>();
        vendedores.add(new VendedorListaDTO("João", 10, 2.5));
        vendedores.add(new VendedorListaDTO("Maria", 15, 3.0));

        when(vendaService.getVendedoresResumoVendasPeriodo(dataInicial, dataFinal)).thenReturn(vendedores);

        mockMvc.perform(get("/vendas/vendedores")
                .param("dataInicial", "2023-01-01")
                .param("dataFinal", "2023-12-31"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].vendedorNome").value("João"))
                .andExpect(jsonPath("$[0].totalVendas").value(10))
                .andExpect(jsonPath("$[0].mediaDiariaVendas").value(2.5))
                .andExpect(jsonPath("$[1].vendedorNome").value("Maria"))
                .andExpect(jsonPath("$[1].totalVendas").value(15))
                .andExpect(jsonPath("$[1].mediaDiariaVendas").value(3.0));
    }

}
