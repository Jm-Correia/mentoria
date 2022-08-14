package br.com.mentoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mentoria.dao.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repo;
	
	@GetMapping()
	public ResponseEntity<?> getAllProdutosByPageable(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size,
			@RequestParam(value = "orderBy", defaultValue = "ID") String orderBy, @RequestParam(value = "direction", defaultValue = "ASC") String direction){
		
		var produtos = repo.findAll(PageRequest.of(page-1, size));
		return ResponseEntity.ok().body(produtos); 
	}
	
}
