package br.com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entities.Editora;
import br.com.residencia.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repository;
	
	// read
	public List<Editora> listarTudo() {
		return repository.findAll();
	}
	
	// read by id
	public Editora buscarPorId(Integer id) {
		// primeira versao
		//return repository.findById(id).get();		
		return repository.findById(id).orElse(null);
	}
	
	// create, aqui ele está criando um editora, quando cria um editora n dá a coluna de ID
	public Editora criar(Editora editora) {
		return repository.save(editora);
	}
	
	// update, aqui ele está atualizando um editora, ele diferencia por causa do ID 
	// quando atualiza tem que botar o ID
	public Editora atualizar(Editora editora) {
		return repository.save(editora);
	}
	
	// delete pelo objeto 
	public boolean deletar(Editora editora) {
		if(editora == null) {
			return false;
		}
		
		Editora editoraExist = buscarPorId(editora.getCodigoEditora());
		
		if(editoraExist == null) {
			return false;
		}
		
		repository.delete(editora);
		
		Editora editoraContinuaExist = buscarPorId(editora.getCodigoEditora());
		
		if(editoraContinuaExist == null) {
			return true;
		}
		
		return false;
	}
	
}
