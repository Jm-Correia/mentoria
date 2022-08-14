package br.com.mentoria.enumerator;

import java.math.BigDecimal;
import java.math.MathContext;

public enum Categoria {

	food(1, "Food", 15.00){

		@Override
		public BigDecimal desconto(final Integer qtd, final Double preco) {
			
			if(qtd < 3) {
				return new BigDecimal(0.0);
			}
			
			var totalDesconto = new BigDecimal(preco).multiply(new BigDecimal(this.getPercentualDesconto()).divide(new BigDecimal(100)));
			
			return totalDesconto.round(new MathContext(4));
			
		}
		
	}, eletronico(2, "Eletronico", 0.00) {
		@Override
		public BigDecimal desconto(final Integer qtd, final Double preco) {
			// TODO Auto-generated method stub
			return new BigDecimal(0.0);
		}
	}, books(3, "Books", 0.00){
		@Override
		public BigDecimal desconto(final Integer qtd, final Double preco) {
			// TODO Auto-generated method stub
			return new BigDecimal(0.0);
		}
		
	};
	
	private int id;
	private String descricao;
	private Double percentualDesconto;
	
	private Categoria(int id, String descricao, Double percentual ) {
		this.id = id;
		this.descricao = descricao;
		this.percentualDesconto = percentual;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Double getPercentualDesconto() {
		return this.percentualDesconto;
	}

	public abstract BigDecimal desconto(final Integer qtd, final Double preco);
		
}
