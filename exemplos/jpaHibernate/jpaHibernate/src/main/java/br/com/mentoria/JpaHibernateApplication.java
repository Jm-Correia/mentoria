package br.com.mentoria;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mentoria.entity.Person;
import br.com.mentoria.service.PersonService;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Autowired
	private PersonService service;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Salvar uma nova Person");
		Person p1 = new Person(null, "Joao", "Correia");
		
		p1 = service.save(p1);
		logger.info(String.format("Person %s %s agora tem o id: %s", p1.getName(), p1.getLastName(), p1.getId().toString()));
		logger.info("FIM da transacao salvar uma nova Person");
		p1.setAddress("1159 Regent Street");
		p1.setAddressComp("unit 10");

		service.save(p1);
	}

}
