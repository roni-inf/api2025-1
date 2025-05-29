package org.serratec.backend.dto;

import java.io.Serializable;

import org.serratec.backend.entity.Procedimentos;

public class ProcedimentosResponseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exame;
	private Integer quantidade;
	private Double valorProcedimento;
	private double subTotal = 0.0;

	public ProcedimentosResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProcedimentosResponseDTO(Procedimentos procedimentos) {
		this.exame = procedimentos.getExame().getTipo();
		this.quantidade = procedimentos.getQuantidade();
		this.valorProcedimento = procedimentos.getValorProcedimento();
		this.subTotal = procedimentos.getSubTotal();
	}
	
	
	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorProcedimento() {
		return valorProcedimento;
	}

	public void setValorProcedimento(Double valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

}
