package br.com.mentoria.model;

import br.com.mentoria.enumerator.Categoria;

public class Produto {

	private Integer id;
	private String nome;
	private Double preco;
	private String photoUrl;
	
	private Categoria categoria;
		

	public Produto() {
		super();
	}

	public Produto(String nome, Double preco, String photoUrl, Categoria categoria) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.photoUrl = photoUrl;
		this.categoria = categoria;
	}
	
	
	public Produto(Integer id, String nome, Double preco, String photoUrl, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.photoUrl = photoUrl;
		this.categoria = categoria;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
