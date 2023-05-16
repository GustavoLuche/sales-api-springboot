package com.projeto.salesapiapringboot.models;

import java.time.LocalDate;
import java.util.Objects;

public class Venda {
	
	private Long id;
	private LocalDate dataVenda;
	private Double valor;
	private Vendedor vendedor;
	
	public Venda() {
	}

	public Venda(Long id, LocalDate dataVenda, Double valor, Vendedor vendedor) {
		this.id = id;
		this.dataVenda = dataVenda;
		this.valor = valor;
		this.vendedor = vendedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(id, other.id);
	}
	
}
