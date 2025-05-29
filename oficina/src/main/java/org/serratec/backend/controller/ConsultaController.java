package org.serratec.backend.controller;

import org.serratec.backend.dto.ConsultaResponseDTO;
import org.serratec.backend.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService service;

	@GetMapping("{id}")
	public ResponseEntity<ConsultaResponseDTO> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscar(id));
	}
}
