package br.com.mentoria.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import br.com.mentoria.enumerator.Categoria;

public class ItemPerdidoTest {

	
	@Test
	public void calcularDescontoItems() {
		
		Produto p1 = new Produto("Pao de frances", 4.9, null, Categoria.food);
		Produto p2 = new Produto("Pao de Forma", 8.9, null, Categoria.food);
		Produto p3 = new Produto("Queijo", 12.9, null, Categoria.food);
		
		ItemPerdido item1 = new ItemPerdido(1, p1.getPreco(), p1);
		ItemPerdido item2 = new ItemPerdido(3, p2.getPreco(), p2);
		ItemPerdido item3 = new ItemPerdido(5, p3.getPreco(), p3);
		
		
		assertEquals(0, item1.calcularDesconto());
		assertEquals(4.005, item2.calcularDesconto());
		assertEquals(9.675, item3.calcularDesconto());
	}
	
	@Test
	public void calcularTotalItems() {
		
		Produto p1 = new Produto("Pao de frances", 4.9, null, Categoria.food);
		Produto p2 = new Produto("Pao de Forma", 8.9, null, Categoria.food);
		Produto p3 = new Produto("Queijo", 12.9, null, Categoria.food);
		
		ItemPerdido item1 = new ItemPerdido(1, p1.getPreco(), p1);
		ItemPerdido item2 = new ItemPerdido(3, p2.getPreco(), p2);
		ItemPerdido item3 = new ItemPerdido(5, p3.getPreco(), p3);
		item1.calcularDesconto();
		item2.calcularDesconto();
		item3.calcularDesconto();
		
		var items = Arrays.asList(item1, item2, item3);
		
		assertEquals(82.42, ItemPerdido.getTotal(items));
	}
}
