package br.com.residencia.biblioteca.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {

	/*
	 * 	CREATE TABLE public.livro (
		codigolivro serial NOT NULL,
		nomelivro varchar(120) NOT NULL,
		nomeautor varchar(100) NULL,
		datalancamento date NULL,
		codigoisbn int4 NOT NULL,
		codigoeditora int4 NOT NULL,
		CONSTRAINT livros_pkey PRIMARY KEY (codigolivro)
		);
	 */
	
	// Criação dos atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigolivro")
	private Integer codigoLivro;
	
	@Column(name = "nomelivro")
	private Integer nomeLivro;
	
	@Column(name = "nomeautor")
	private Integer nomeAutor;
	
	@Column(name = "datalancamento")
	private Integer dataLancamento;
	
	@Column(name = "codigoisbn")
	private Integer codigoIsbn;
	
	@OneToMany(mappedBy = "livro")
	private List<Emprestimo> emprestimos;
	
	@ManyToOne
	@JoinColumn(name = "codigoeditora", referencedColumnName = "codigoeditora")
	private Editora editora;

	// Getters e Setters
	
	public Integer getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(Integer codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public Integer getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(Integer nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public Integer getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(Integer nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Integer getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Integer atalancamento) {
		this.dataLancamento = atalancamento;
	}

	public Integer getCodigoIsbn() {
		return codigoIsbn;
	}

	public void setCodigoIsbn(Integer codigoIsbn) {
		this.codigoIsbn = codigoIsbn;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
}
