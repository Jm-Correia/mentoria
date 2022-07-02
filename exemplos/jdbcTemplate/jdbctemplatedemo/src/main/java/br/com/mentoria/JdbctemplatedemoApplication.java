package br.com.mentoria;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mentoria.model.Person;
import br.com.mentoria.repository.PersonRepository;

@SpringBootApplication
public class JdbctemplatedemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(JdbctemplatedemoApplication.class, args);
	}

	@Autowired
	private PersonRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Person p1 = new Person(1, "Fulano", "de tal");
		Person p2 = new Person(2, "Beltrano", "de tal");
		Person p3 = new Person(3, "Siclano", "de tal");
		// TODO Auto-generated method stub
		logger.info(String.format("Inserindo 3 Pessoas"));
		repo.insert(p1);
		repo.insert(p2);
		repo.insert(p3);
		logger.info("-------------------------------");
		logger.info("Consultando todas as pessoas");
		repo.findAll()
			.stream()
			.forEach(person -> logger.info(person.toString()));
		
		logger.info("-------------------------------");
		logger.info(String.format("Alterando ultimo nome de %s", p1.getName()));
		p1.setLastName("Correia");
		p1 = repo.update(p1).get();
		logger.info(p1.toString());
		logger.info("-------------------------------");
	}

}
