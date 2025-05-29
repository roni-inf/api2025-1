package org.serratec.backend.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.serratec.backend.entity.Consulta;

public class ConsultaResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LocalDate dataConsulta;
	private String nomePaciente;
	private String nomeMedico;
	private List<ProcedimentosResponseDTO> procedimentosResponseDTO;
	private double totalGeral=0.0;

	public ConsultaResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public ConsultaResponseDTO(Consulta consulta) {
		this.dataConsulta = consulta.getDataConsulta();
		this.nomePaciente = consulta.getPaciente().getNome();
		this.nomeMedico = consulta.getMedico().getNome();
		this.procedimentosResponseDTO = consulta.getProcedimentos().stream().map(p -> new ProcedimentosResponseDTO(p))
				.collect(Collectors.toList());
		 this.totalGeral = consulta.getTotalGeral();
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public List<ProcedimentosResponseDTO> getProcedimentosResponseDTO() {
		return procedimentosResponseDTO;
	}

	public double getTotalGeral() {
		return totalGeral;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public void setProcedimentosResponseDTO(List<ProcedimentosResponseDTO> procedimentosResponseDTO) {
		this.procedimentosResponseDTO = procedimentosResponseDTO;
	}

	public void setTotalGeral(Double totalGeral) {
		this.totalGeral = totalGeral;
	}

	public void setTotalGeral(double totalGeral) {
		this.totalGeral = totalGeral;
	}
	
	
	

}
