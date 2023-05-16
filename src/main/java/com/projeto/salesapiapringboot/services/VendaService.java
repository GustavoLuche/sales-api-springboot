package com.projeto.salesapiapringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.salesapiapringboot.dto.VendaDTO;
import com.projeto.salesapiapringboot.models.Venda;
import com.projeto.salesapiapringboot.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Transactional(readOnly = true)
	public List<VendaDTO> findAll() {
		List<Venda> result = vendaRepository.findAll();
		return result.stream().map(x -> new VendaDTO(x)).toList();
	}
	
}
