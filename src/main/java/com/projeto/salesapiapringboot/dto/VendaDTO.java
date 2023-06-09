package com.projeto.salesapiapringboot.dto;

import java.time.LocalDate;

import com.projeto.salesapiapringboot.models.Venda;

public class VendaDTO {

	private Long id;
	private LocalDate dataVenda;
	private Double valor;
	private Long vendedorId;
	private String vendedorNome;

	public VendaDTO() {
	}

	public VendaDTO(Venda entity) {
		id = entity.getId();
		dataVenda = entity.getDataVenda();
		valor = entity.getValor();
		vendedorId = entity.getVendedor().getId();
		vendedorNome = entity.getVendedor().getNome();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public Double getValor() {
		return valor;
	}

	public Long getVendedorId() {
		return vendedorId;
	}

	public String getVendedorNome() {
		return vendedorNome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setVendedorId(Long vendedorId) {
		this.vendedorId = vendedorId;
	}

	public void setVendedorNome(String vendedorNome) {
		this.vendedorNome = vendedorNome;
	}

}
