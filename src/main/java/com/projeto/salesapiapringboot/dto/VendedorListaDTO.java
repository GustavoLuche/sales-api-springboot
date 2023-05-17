package com.projeto.salesapiapringboot.dto;

import com.projeto.salesapiapringboot.projections.VendedorListaProjection;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class VendedorListaDTO {

	@Size(max = 100, message = "O nome do vendedor deve ter no máximo 100 caracteres")
	private String vendedorNome;

	@Positive(message = "O valor da venda deve ser positivo")
    private Integer totalVendas;

	@Positive(message = "O valor da venda deve ser positivo")
    private Double mediaDiariaVendas;
    
	public VendedorListaDTO() {
	}

	public VendedorListaDTO(String vendedorNome, Integer totalVendas, Double mediaDiariaVendas) {
		this.vendedorNome = vendedorNome;
		this.totalVendas = totalVendas;
		this.mediaDiariaVendas = mediaDiariaVendas;
	}

	public VendedorListaDTO(VendedorListaProjection projection) {
		vendedorNome = projection.getVendedorNome();
		totalVendas = projection.getTotalVendas();
		mediaDiariaVendas = projection.getMediaDiariaVendas();
	}

	public String getVendedorNome() {
		return vendedorNome;
	}

	public void setVendedorNome(String vendedorNome) {
		this.vendedorNome = vendedorNome;
	}

	public Integer getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(Integer totalVendas) {
		this.totalVendas = totalVendas;
	}

	public Double getMediaDiariaVendas() {
		return mediaDiariaVendas;
	}

	public void setMediaDiariaVendas(Double mediaDiariaVendas) {
		this.mediaDiariaVendas = mediaDiariaVendas;
	}
  
	
}
