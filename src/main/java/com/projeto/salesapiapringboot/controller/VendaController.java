package com.projeto.salesapiapringboot.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.salesapiapringboot.dto.VendaDTO;
import com.projeto.salesapiapringboot.dto.VendedorListaDTO;
import com.projeto.salesapiapringboot.models.Venda;
import com.projeto.salesapiapringboot.services.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	public VendaController(VendaService vendaService) {
		this.vendaService = vendaService;
	}

	@GetMapping
	public List<VendaDTO> findAll() {
		List<VendaDTO> result = vendaService.findAll();
		return result;
	}

	@PostMapping
	public ResponseEntity<Venda> criarVenda(@RequestBody VendaDTO vendaDTO) {
		Venda venda = vendaService.criarVenda(vendaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(venda);
	}

	@GetMapping("/vendedores")
	public List<VendedorListaDTO> getVendedoresResumoVendasPeriodo(
			@RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
			@RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		return vendaService.getVendedoresResumoVendasPeriodo(dataInicial, dataFinal);
	}

}
