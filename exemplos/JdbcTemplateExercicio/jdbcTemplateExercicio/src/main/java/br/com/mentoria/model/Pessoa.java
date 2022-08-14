package br.com.mentoria.model;

import java.util.ArrayList;
import java.util.List;

import br.com.mentoria.enumerator.TipoPessoa;

public class Pessoa extends BaseEntity<Integer> {

	private String nome;
	
	private String email;
	
	private String cpfOuCnpj;
	
	private TipoPessoa tipo;
	
	public static String entityName = "PESSOA";
	
	
	private List<Endereco> enderecos = new ArrayList<>();
	private List<Telefone> telefones = new ArrayList<>();
	
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
				+ tipo.getId() + " "+ tipo.getValue() + "]";
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



	public List<Endereco> getEnderecos() {
		return enderecos;
	}



	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}



	public List<Telefone> getTelefones() {
		return telefones;
	}



	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}


//	@Override
//	public String getEntityName() {
//		return getClass().getName().toUpperCase();
//	}



	
	
	
	
}
