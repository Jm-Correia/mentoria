package br.com.mentoria.model;

@SuppressWarnings("serial")
public class Endereco extends BaseEntity<Integer> {
	
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	private Integer pessoaId;
	
	private Cidade cidade;
	
		
	public Endereco() {
		
	}
	
	public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep, Integer pessoaId, Cidade cidadeId) {
		
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.pessoaId = pessoaId;
		this.cidade = cidadeId;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}
	
	

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento="
				+ complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidadeId=" + cidade.getId() + "]";
	}


	


	
	
}
