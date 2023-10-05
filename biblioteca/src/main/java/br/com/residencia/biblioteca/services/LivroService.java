package br.com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entities.Livro;
import br.com.residencia.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	// read
	public List<Livro> listarTudo() {
		return repository.findAll();
	}
	
	// read by id
	public Livro buscarPorId(Integer id) {
		// primeira versao
		return repository.findById(id).get();		
	}
	
	// create, aqui ele está criando um aluno, quando cria um aluno n dá a coluna de ID
	public Livro criar(Livro livro) {
		return repository.save(livro);
	}
	
	// update, aqui ele está atualizando um aluno, ele diferencia por causa do ID 
	// quando atualiza tem que botar o ID
	public Livro atualizar(Livro livro) {
		return repository.save(livro);
	}
	
	// delete pelo objeto 
	public void deletar(Livro livro) {
		repository.delete(livro);
	}
	
}
