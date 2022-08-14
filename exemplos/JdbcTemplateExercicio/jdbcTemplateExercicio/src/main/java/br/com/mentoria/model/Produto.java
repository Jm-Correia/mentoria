package br.com.mentoria.model;

import br.com.mentoria.enumerator.Categoria;

@SuppressWarnings("serial")
public class Produto extends BaseEntity<Integer> {

	private String nome;
	private Double preco;
	private final String photoUrl = "https://api.lorem.space/image/book?w=150&amp;amp;amp;amp;h=220";
	private Categoria categoria;
		

	public Produto() {
		super();
	}

	public Produto(String nome, Double preco, Categoria categoria) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	
	public Produto(Integer id, String nome, Double preco, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	
	public Integer getId() {
		return id;
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


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + ", categoria=" + categoria + "]";
	}
	
	
	
}
