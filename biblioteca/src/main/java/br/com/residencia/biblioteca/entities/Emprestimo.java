package br.com.residencia.biblioteca.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {

	/*
	 * 	CREATE TABLE public.emprestimo (
		codigoemprestimo serial NOT NULL,
		numeromatriculaaluno int4 NOT NULL,
		codigolivro int4 NOT NULL,
		dataemprestimo date NOT NULL DEFAULT now(),
		dataentrega date NULL,
		valoremprestimo numeric(10,2) NULL,
		CONSTRAINT emprestimo_pkey PRIMARY KEY (codigoemprestimo)
		);
	 */
	
	// Criação dos atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoemprestimo")
	private Integer codigoEmprestimo;
	
	@ManyToOne
	@JoinColumn(name = "numeromatriculaaluno", referencedColumnName = "numeromatriculaaluno")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "codigolivro", referencedColumnName = "codigolivro")
	private Livro livro;
	
	@Column(name = "dataemprestimo")
	private Date dataEmprestimo;
	
	@Column(name = "dataentrega")
	private Date dataEntrega;
	
	@Column(name = "valoremprestimo")
	private BigDecimal valorEmprestimo;

	// Getters e Setters
	
	public Integer getCodigoEmprestimo() {
		return codigoEmprestimo;
	}

	public void setCodigoEmprestimo(Integer codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
	}

//	public Integer getCodigoLivro() {
//		return codigoLivro;
//	}
//
//	public void setCodigoLivro(Integer codigoLivro) {
//		this.codigoLivro = codigoLivro;
//	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(BigDecimal valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
	
}
