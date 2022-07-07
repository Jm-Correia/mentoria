package br.com.mentoria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mentoria.entity.Person;
import br.com.mentoria.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repo;
	
	public Person save(Person person) {
		return repo.save(person);
	}
	
	public List<Person> findAll(){
		return repo.findAll();
	}
	
}
