package com.projeto.salesapiapringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.salesapiapringboot.dto.VendaDTO;
import com.projeto.salesapiapringboot.models.Venda;
import com.projeto.salesapiapringboot.models.Vendedor;
import com.projeto.salesapiapringboot.repositories.VendaRepository;
import com.projeto.salesapiapringboot.repositories.VendedorRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Transactional(readOnly = true)
	public List<VendaDTO> findAll() {
		List<Venda> result = vendaRepository.findAll();
		return result.stream().map(x -> new VendaDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public Venda criarVenda(VendaDTO vendaDTO) {
		Vendedor vendedor = vendedorRepository.findById(vendaDTO.getVendedorId()).orElseThrow(() ->
				new IllegalArgumentException("Vendedor com o ID especificado não encontrado"));
		Venda venda = new Venda(vendaDTO.getDataVenda(), vendaDTO.getValor(), vendedor);
		return vendaRepository.save(venda);
	}
}
