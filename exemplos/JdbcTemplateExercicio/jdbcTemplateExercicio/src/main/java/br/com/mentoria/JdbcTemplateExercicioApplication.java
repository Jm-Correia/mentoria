package br.com.mentoria;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mentoria.dao.PessoaRepository;
import br.com.mentoria.enumerator.TipoPessoa;
import br.com.mentoria.model.Pessoa;

@SpringBootApplication
public class JdbcTemplateExercicioApplication implements CommandLineRunner {

	private Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass()); 
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateExercicioApplication.class, args);
	}

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa(1, "Test", "Test@test.com", "0000000", TipoPessoa.cpf);
		System.out.println(TipoPessoa.getId(TipoPessoa.cpf));
		log.info(p1.toString());
		log.info("Inserindo no h2 database");
		pessoaRepository.insert(p1);
	}

}
