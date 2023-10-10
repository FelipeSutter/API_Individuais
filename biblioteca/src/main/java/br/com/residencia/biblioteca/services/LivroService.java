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
		//return repository.findById(id).get();	
		return repository.findById(id).orElse(null);
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
	public boolean deletar(Livro livro) {
		if(livro == null) {
			return false;
		}
		
		Livro livroExist = buscarPorId(livro.getCodigoLivro());
		
		if(livroExist == null) {
			return false;
		}
		
		repository.delete(livro);
		
		Livro livroContinuaExist = buscarPorId(livro.getCodigoLivro());
		
		if(livroContinuaExist == null) {
			return true;
		}
		
		return false;
	}
	
}
