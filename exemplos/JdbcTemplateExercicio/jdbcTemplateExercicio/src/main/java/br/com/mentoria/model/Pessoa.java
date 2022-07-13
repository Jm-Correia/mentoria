package br.com.mentoria.model;

import br.com.mentoria.enumerator.TipoPessoa;

public class Pessoa {

	private Integer id;
	
	private String nome;
	
	private String email;
	
	private String cpfOuCnpj;
	
	private TipoPessoa tipo;

	public Pessoa() {
	}
	
	
	
	public Pessoa(Integer id, String nome, String email, String cpfOuCnpj, TipoPessoa tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
	}



	public Pessoa(Integer id, String nome, String email, String cpfOuCnpj, Integer tipo) {
		this.id= id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = TipoPessoa.getTipo(tipo);
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", cpfOuCnpj=" + cpfOuCnpj + ", tipo="
				+ tipo + "]";
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}
	
	
	
}
