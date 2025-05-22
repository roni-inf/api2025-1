package org.serratec.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.entity.Aluno;
import org.serratec.backend.revisao.ExemploController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final ExemploController exemploController;
	private static List<Aluno> alunos = new ArrayList();
	static {
		alunos.add(new Aluno(123L, "Adriano", "adriano@gmail.com"));
		alunos.add(new Aluno(321L, "Mariana", "marcelo@gmail.com"));
		alunos.add(new Aluno(345L, "Gerson", "gerson@gmail.com"));
		alunos.add(new Aluno(545L, "Marcelo", "marcelo@gmail.com"));
	}

    AlunoController(ExemploController exemploController) {
        this.exemploController = exemploController;
    }

	@GetMapping
	public List<Aluno> listar() {
		return alunos;
	}

	@GetMapping("/{matricula}")
	public Aluno buscar(@PathVariable Long matricula) {

		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				return aluno;
			}
		}
		return null;
	}

	@PostMapping
	public Aluno inserir(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return aluno;
	}

	@PostMapping("/varios")
	public List<Aluno> inserir(@RequestBody List<Aluno> alunosNovos) {
		alunos.addAll(alunosNovos);
		return alunos;
	}

	@DeleteMapping("/{matricula}")
	public void apagar(@PathVariable Long matricula) {
		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				alunos.remove(aluno);
				break;
			}
		}
	}

	@PutMapping("/{matricula}")
	public Aluno atualizar(@PathVariable Long matricula, @RequestBody Aluno aluno) {
		for (Aluno a : alunos) {
			if (a.getMatricula().equals(matricula)) {
				aluno.setMatricula(matricula);
				alunos.set(alunos.indexOf(a), aluno);
				return aluno;
			}
		}
		return null;
	}

}
