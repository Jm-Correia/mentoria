package br.com.mentoria.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.mentoria.enumerator.Categoria;

public class CategoriaTest {

	@Test
	public void calculateDescontoParaOneProdutoFood() {
		assertEquals(0, Categoria.food.desconto(1, 12.9).intValue());
	}
	
	@Test
	public void calculateDescontoPara5ProdutoFood() {
		var desconto = Categoria.food.desconto(5, 50.0);
		assertEquals(7.50, desconto.doubleValue());
	}
	
	@Test
	public void calculateDescontoPara5ProdutoEletronico() {
		var desconto = Categoria.eletronico.desconto(5, 50.0);
		assertEquals(0, desconto.intValue());
	}
	
}
