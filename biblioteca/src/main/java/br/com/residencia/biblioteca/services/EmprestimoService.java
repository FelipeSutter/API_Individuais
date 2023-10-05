package br.com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entities.Emprestimo;
import br.com.residencia.biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;
	
	// read
	public List<Emprestimo> listarTudo() {
		return repository.findAll();
	}
	
	// read by id
	public Emprestimo buscarPorId(Integer id) {
		// primeira versao
		return repository.findById(id).get();		
	}
	
	// create, aqui ele está criando um aluno, quando cria um aluno n dá a coluna de ID
	public Emprestimo criar(Emprestimo emprestimo) {
		return repository.save(emprestimo);
	}
	
	// update, aqui ele está atualizando um aluno, ele diferencia por causa do ID 
	// quando atualiza tem que botar o ID
	public Emprestimo atualizar(Emprestimo emprestimo) {
		return repository.save(emprestimo);
	}
	
	// delete pelo objeto 
	public void deletar(Emprestimo emprestimo) {
		repository.delete(emprestimo);
	}
	
}
