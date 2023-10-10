package br.com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entities.Aluno;
import br.com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	// read
	public List<Aluno> listarTudo() {
		return repository.findAll();
	}
	
	// read by id
	public Aluno buscarPorId(Integer id) {
		// primeira versao
		//return repository.findById(id).get();		
		
		/* versao com excecao
		 return repository.findById(id).orElseThrow(() -> new RuntimeException());
		 */
		
		/*
		 * Optional<Aluno> alunoBanco = alunoRepo.findById(id);
			if(alunoBanco.isPresent())
				return alunoBanco.get();
			else
				return null;
		 */
		// versão de uma linha
		return repository.findById(id).orElse(null);
	}
	
	// create, aqui ele está criando um aluno, quando cria um aluno n dá a coluna de ID
	public Aluno criar(Aluno aluno) {
		return repository.save(aluno);
	}
	
	// update, aqui ele está atualizando um aluno, ele diferencia por causa do ID 
	// quando atualiza tem que botar o ID
	public Aluno atualizar(Aluno aluno) {
		return repository.save(aluno);
	}
	
	// delete pelo objeto 
	public void deletar(Aluno aluno) {
		repository.delete(aluno);
		/*
		 * Aluno confereAlunoDeletado = buscarPorId(aluno.getNumeroMatriculaAluno());
		 */
	}
	
	/* delete pelo ID 
	public void deletarAluno(Integer id) {
		repository.deleteById(id);
	} */
	
}
