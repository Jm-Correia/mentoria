package br.com.mentoria.model;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Estado extends BaseEntity<Integer> {

	
	private String nome;
	
	private List<Cidade> cidades = new ArrayList<>();
	
	
	public Estado() {
		super();
	}
	
	
	public Estado(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	

	public Estado(Integer id, String nome, List<Cidade> cidades) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidades = cidades;
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


	public List<Cidade> getCidades() {
		return cidades;
	}


	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	
	
	
}
