package br.com.mentoria.model;

public class Telefone {

	private Integer id;
	private String ddd;
	private String numero;
	
	private Integer pessoaId;
	
	public Telefone() {
		
	}
	

	public Telefone(String ddd, String numero, Integer pessoaId) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.pessoaId = pessoaId;
	}


	public Telefone(Integer id, String ddd, String numero, Integer pessoaId) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
		this.pessoaId = pessoaId;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}
	
	
}
