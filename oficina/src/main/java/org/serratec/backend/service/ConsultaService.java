package org.serratec.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.backend.dto.ConsultaResponseDTO;
import org.serratec.backend.entity.Consulta;
import org.serratec.backend.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;

	public ConsultaResponseDTO buscar(Long id) {
		Optional<Consulta> consulta = repository.findById(id);
		return new ConsultaResponseDTO(consulta.get());
	}

		
	public List<ConsultaResponseDTO> listar() {
		List<Consulta> consultas = repository.findAll();
		return consultas.stream().map(consulta -> new ConsultaResponseDTO(consulta)).collect(Collectors.toList());
	}

}
