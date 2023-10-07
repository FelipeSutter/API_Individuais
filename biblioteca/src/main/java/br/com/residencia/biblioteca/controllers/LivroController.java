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

import br.com.residencia.biblioteca.entities.Livro;
import br.com.residencia.biblioteca.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService service;
	
	@GetMapping
	public ResponseEntity<List<Livro>> listarTudo() {
		return new ResponseEntity<>(service.listarTudo(), HttpStatus.OK);
		// outro jeito de fazer
		// ResponseEntity.ok(service.listarTudo())
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarPorId(@PathVariable Integer id) {
		return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
		
		// outro jeito de fazer
		// ResponseEntity.ok(service.buscarPorId(id))
	}
	
	@PostMapping
	public ResponseEntity<Livro> criar(@RequestBody Livro livro) {
		return new ResponseEntity<>(service.criar(livro), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Livro> atualizar(@RequestBody Livro livro) {
		return new ResponseEntity<>(service.atualizar(livro), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deletar(@RequestBody Livro livro) {
		service.deletar(livro);
		return new ResponseEntity<>("Deletado com Sucesso!", HttpStatus.OK);
	}
	
}