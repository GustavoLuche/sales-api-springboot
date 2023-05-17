package com.projeto.salesapiapringboot.dto;

import java.time.LocalDate;

import com.projeto.salesapiapringboot.models.Venda;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class VendaDTO {

	private Long id;

	@NotNull(message = "A data de venda não pode ser nula")
	private LocalDate dataVenda;

	@Positive(message = "O valor da venda deve ser positivo")
	private Double valor;

	@NotNull(message = "O ID do vendedor não pode ser nulo")
	private Long vendedorId;

	@Size(max = 100, message = "O nome do vendedor deve ter no máximo 100 caracteres")
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
