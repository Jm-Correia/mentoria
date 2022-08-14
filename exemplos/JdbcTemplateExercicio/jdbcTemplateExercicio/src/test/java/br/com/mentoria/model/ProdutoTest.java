package br.com.mentoria.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.com.mentoria.enumerator.Categoria;

public class ProdutoTest {

	@Test
	public void createNewProduto() {
		Produto produto = new Produto("Pao de Forma", 8.9,  Categoria.food);
		assertNotNull(produto);
	}
	
	@Test
	public void createNewProdutoEAplicaDesconto() {
		Produto produto = new Produto("Pao de Forma", 8.9,  Categoria.food);
		assertEquals(0, produto.getCategoria().desconto(1, produto.getPreco()).intValue());
		
	}
	@Test
	public void create3ProdutosEApliqueDesconto() {
		Produto p1 = new Produto("Pao de frances", 4.9,  Categoria.food);
		Produto p2 = new Produto("Pao de Forma", 8.9,  Categoria.food);
		Produto p3 = new Produto("Queijo", 12.9,  Categoria.food);
		var total = p1.getPreco()+p2.getPreco()+p3.getPreco();
		assertEquals(4.005, Categoria.food.desconto(3, total).doubleValue());
		
	}
	
}
