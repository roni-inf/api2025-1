package org.serratec.backend.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataConsulta;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_medico")
	private Medico medico;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	@OneToMany(mappedBy = "consulta")
	private List<Procedimentos> procedimentos;

	@Transient
	private double totalGeral = 0.0;

	public double getTotalGeral() {
		for (Procedimentos procedimento : procedimentos) {
			totalGeral = totalGeral + procedimento.getSubTotal();
		}
		return totalGeral;
	}

	public void setTotalGeral(double totalGeral) {
		this.totalGeral = totalGeral;
	}

	public List<Procedimentos> getProcedimentos() {
		return procedimentos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
