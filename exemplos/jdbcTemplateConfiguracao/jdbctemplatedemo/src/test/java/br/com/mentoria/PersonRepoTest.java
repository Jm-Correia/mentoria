package br.com.mentoria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import br.com.mentoria.config.H2DbConfig;
import br.com.mentoria.model.Person;
import br.com.mentoria.repository.PersonRepository;

@SpringJUnitConfig(classes = {H2DbConfig.class, PersonRepository.class})
public class PersonRepoTest {

	
	@Autowired
	PersonRepository repo;
	
	
	@BeforeEach
	void setup() {
		assertNotNull(repo);
	}
	
	
	@Test
	public void testFindByIdPositive() {
		repo.insert(new Person(1, "Fulano", "De tal"));
		repo.findById(1).ifPresentOrElse(p-> assertEquals("Fulano", p.getName()), Assertions::fail);
	}
}
