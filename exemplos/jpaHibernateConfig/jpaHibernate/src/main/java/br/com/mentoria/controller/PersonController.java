package br.com.mentoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mentoria.entity.Person;
import br.com.mentoria.service.PersonService;

@RestController
@RequestMapping(path = "/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}

}
