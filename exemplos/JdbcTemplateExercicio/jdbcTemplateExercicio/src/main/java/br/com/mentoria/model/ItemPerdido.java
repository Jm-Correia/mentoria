package br.com.mentoria.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class ItemPerdido {

	private Double desconto;
	private Integer quantidade;
	private Double preco;
	private Produto produto;

	public ItemPerdido(Double desconto, Integer quantidade, Double preco, Produto produto) {
		super();
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}
	
	
	public ItemPerdido(Integer quantidade, Double preco, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}


	public static Double getTotal(List<ItemPerdido> items) {
		Double total = 0.0;
		for(ItemPerdido item: items) {
			total += (item.preco*item.quantidade)-item.desconto;
		}
		return new BigDecimal(total).round(new MathContext(4)).doubleValue();
	}
	
	public Double calcularDesconto() {
		this.desconto = produto.getCategoria().desconto(quantidade, preco*quantidade).doubleValue();
		return desconto;
	}
	
	
}
