package br.com.residencia.biblioteca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "editora")
public class Editora {
	
	/*
	 * 	CREATE TABLE public.editora (
		codigoeditora serial NOT NULL,
		nome varchar(50) NOT NULL,
		imagem_nome varchar(255),
		magem_filename varchar(255),
		imagem_url varchar(255),	
		CONSTRAINT editora_pkey PRIMARY KEY (codigoeditora)
		);
	 */
	
	// Criação dos atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoeditora")
	private Integer codigoEditora;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "imagem_nome")
	private String imagemNome;
	
	@Column(name = "imagem_filename")
	private String imagemFilename;
	
	@Column(name = "imagem_url")
	private String imagemUrl;

	// Getters e Setters
	
	public Integer getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(Integer codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagemFilename() {
		return imagemFilename;
	}

	public void setImagemFilename(String imagemFilename) {
		this.imagemFilename = imagemFilename;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}
	
	
}
