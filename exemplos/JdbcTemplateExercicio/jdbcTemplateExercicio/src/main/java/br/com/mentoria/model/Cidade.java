package br.com.mentoria.model;

public class Cidade {

	private Integer id;
	private String nome;
	private Integer estadoId;
	
	
	public Cidade(Integer id) {
		super();
		this.id = id;
	}


	public Cidade(Integer id, String nome, Integer estadoId) {
		super();
		this.id = id;
		this.nome = nome;
		this.estadoId = estadoId;
	}


	public Cidade() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public Integer getEstadoId() {
		return estadoId;
	}
	
	
	
}
