package br.com.mentoria.enumerator;

public enum TipoPessoa {

	cpf(1, "cpf"), cnpj(2, "cnpj");
	
	private int id;
	private String value;
	
	private TipoPessoa(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public static int getId(TipoPessoa tipoPessoa) {
		
		for(TipoPessoa tipo: TipoPessoa.values()) {
			if(tipo.equals(tipoPessoa)) {
				return tipo.id;
			}
		}
		return 0;
	}
	
	public static String getValue(int id) {
		
		for(TipoPessoa tipo: TipoPessoa.values()) {
			if(tipo.id == id) {
				return tipo.value;
			}
		}
		return null;
	}
	public static TipoPessoa getTipo(int id) {
		
		for(TipoPessoa tipo: TipoPessoa.values()) {
			if(tipo.id == id) {
				return tipo;
			}
		}
		return null;
	}
	
	
}
