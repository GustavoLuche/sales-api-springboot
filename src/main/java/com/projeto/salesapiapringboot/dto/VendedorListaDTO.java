package com.projeto.salesapiapringboot.dto;

import com.projeto.salesapiapringboot.projections.VendedorListaProjection;

public class VendedorListaDTO {

	private String vendedorNome;
    private Integer totalVendas;
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
