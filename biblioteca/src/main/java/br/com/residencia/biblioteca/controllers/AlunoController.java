package br.com.residencia.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.biblioteca.entities.Aluno;
import br.com.residencia.biblioteca.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> listarTudo() {
		return new ResponseEntity<>(service.listarTudo(), HttpStatus.OK);
		// outro jeito de fazer
		// ResponseEntity.ok(service.listarTudo())
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarPorId(@PathVariable Integer id) {
		return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
		
		// outro jeito de fazer
		// ResponseEntity.ok(service.buscarPorId(id))
	}
	
	/* Outra forma de fazer
	 * @GetMapping("/porid")
	public ResponseEntity<Aluno> buscarAlunoPorId(@RequestParam Integer id) {
		return new ResponseEntity<>(alunoService.buscarAlunoPorId(id), HttpStatus.OK);
	}
	 */
	
	@PostMapping
	public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(service.criar(aluno), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(service.atualizar(aluno), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deletar(@RequestBody Aluno aluno) {
		service.deletar(aluno);
		return new ResponseEntity<>("Deletado com Sucesso!", HttpStatus.OK);
	}
	
}