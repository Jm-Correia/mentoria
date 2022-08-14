package br.com.mentoria;

import java.util.Arrays;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mentoria.dao.CidadeRepository;
import br.com.mentoria.dao.EstadoRepository;
import br.com.mentoria.dao.PessoaRepository;
import br.com.mentoria.enumerator.TipoPessoa;
import br.com.mentoria.model.Cidade;
import br.com.mentoria.model.Endereco;
import br.com.mentoria.model.Estado;
import br.com.mentoria.model.Pessoa;
import br.com.mentoria.service.CadastrarClienteService;

@SpringBootApplication
public class JdbcTemplateExercicioApplication implements CommandLineRunner {

	private Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass()); 
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateExercicioApplication.class, args);
	}

	@Autowired
	private CadastrarClienteService service;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		log.info("Iniciando Configuracao do banco de dados");
		log.info("Inserindo Tabelas de Dominios");
		
		Estado estado = new Estado(1, "Pernambuco");
		estadoRepository.insert(estado);
		Cidade c1 = new Cidade(1, "Recife", 1);
		Cidade c2 = new Cidade(2, "Olinda", 1);
		Cidade c3 = new Cidade(3, "Jaboatao", 1);
		Cidade c4 = new Cidade(4, "Caruarua", 1);
		Cidade c5 = new Cidade(5, "Gravata", 1);
		
		cidadeRepository.insertLote(Arrays.asList(c1, c2, c3, c4, c5));
		
		Pessoa p1 = new Pessoa(null, "Test", "Test@test.com", "000.000.000-00", TipoPessoa.cpf);
		Endereco end = new Endereco(null, "Rua Ferreira Viana", "55", "", "Areias", "50860-190", null, null);
		log.info(p1.toString());
		log.info("Inserindo no h2 database");
		service.cadastrarPessoa(p1, end);
	}

}
