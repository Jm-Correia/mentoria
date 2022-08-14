package br.com.mentoria;

import java.util.Arrays;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import br.com.mentoria.dao.CidadeRepository;
import br.com.mentoria.dao.EstadoRepository;
import br.com.mentoria.dao.ProdutoRepository;
import br.com.mentoria.enumerator.Categoria;
import br.com.mentoria.enumerator.TipoPessoa;
import br.com.mentoria.model.Cidade;
import br.com.mentoria.model.Endereco;
import br.com.mentoria.model.Estado;
import br.com.mentoria.model.Pessoa;
import br.com.mentoria.model.Produto;
import br.com.mentoria.service.CadastrarClienteService;
import br.com.mentoria.service.ConsultarPessoaService;

@SpringBootApplication
public class JdbcTemplateExercicioApplication implements CommandLineRunner {

	private Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass()); 
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateExercicioApplication.class, args);
	}

//	@Autowired
//	private CadastrarClienteService service;
//	
//	@Autowired
//	private ConsultarPessoaService consultarPessoaService;
	
//	@Autowired
//	private EstadoRepository estadoRepository;
//	
//	@Autowired
//	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
//		log.info("Iniciando Configuracao do banco de dados");
//		log.info("Inserindo Tabelas de Dominios");
//		
//		Estado estado = new Estado(1, "Pernambuco");
//		estadoRepository.insertLote(Arrays.asList(estado));
//		Cidade c1 = new Cidade(1, "Recife", 1);
//		Cidade c2 = new Cidade(2, "Olinda", 1);
//		Cidade c3 = new Cidade(3, "Jaboatao", 1);
//		Cidade c4 = new Cidade(4, "Caruarua", 1);
//		Cidade c5 = new Cidade(5, "Gravata", 1);
//		
//		cidadeRepository.insertLote(Arrays.asList(c1, c2, c3, c4, c5));
//		
//		Pessoa p1 = new Pessoa(null, "Test", "Test@test.com", "000.000.000-00", TipoPessoa.cpf);
//		Endereco end = new Endereco(null, "Rua Ferreira Viana", "55", "", "Areias", "50860-190", null, c1);
//		log.info(p1.toString());
//		log.info("Inserindo no h2 database");
//		service.cadastrarPessoa(p1, end);
//		
//		var pessoa = consultarPessoaService.findById(1);
//		log.info("Pessoa {} com os enderecos {}", pessoa.toString(), pessoa.getEnderecos().toString());
//		
		var livroDosCodigos = new Produto("livro dos Codigos", 58.90, Categoria.books);
		var java11CompleteReferencia = new Produto("Java 11 Completa Referencia", 258.90, Categoria.books);
		var pivotCertification = new Produto("PivotCertification", 358.90, Categoria.books);
		var nodeJS = new Produto("Cookbook Node JS 4 edition", 98.90, Categoria.books);
		var batmanAno1 = new Produto("Batman ano 1", 38.90, Categoria.books);
		var batmanAno2 = new Produto("Batman ano 2", 58.90, Categoria.books);
		var batmanAno3 = new Produto("Batman ano 3", 28.90, Categoria.books);
		var batmanAno4 = new Produto("Batman ano 4", 28.90, Categoria.books);
		var batmanAno5 = new Produto("Batman ano 5", 28.90, Categoria.books);
		var batmanAno6 = new Produto("Batman ano 6", 28.90, Categoria.books);
		var batmanAno7 = new Produto("Batman ano 7", 28.90, Categoria.books);
		var batmanAno8 = new Produto("Batman ano 8", 28.90, Categoria.books);
		var batmanAno9 = new Produto("Batman ano 9", 28.90, Categoria.books);
		var batmanAno10 = new Produto("Batman ano 10", 28.90, Categoria.books);
		var batmanAno11 = new Produto("Batman ano 11", 28.90, Categoria.books);
		var batmanAno12 = new Produto("Batman ano 12", 28.90, Categoria.books);
		var batmanAno13 = new Produto("Batman ano 13", 28.90, Categoria.books);
		var batmanAno14 = new Produto("Batman ano 14", 28.90, Categoria.books);
		var batmanAno15 = new Produto("Batman ano 15", 28.90, Categoria.books);
		var batmanAno16 = new Produto("Batman ano 16", 28.90, Categoria.books);
		
		
		produtoRepo.insertLote(
				Arrays.asList(
						livroDosCodigos,
						java11CompleteReferencia,
						pivotCertification,
						nodeJS,
						batmanAno1,
						batmanAno2,
						batmanAno3,
						batmanAno4,
						batmanAno5,
						batmanAno6,
						batmanAno7,
						batmanAno8,
						batmanAno9,
						batmanAno10,
						batmanAno11,
						batmanAno12,
						batmanAno13,
						batmanAno14,
						batmanAno15,
						batmanAno16));
		
		PageRequest page = PageRequest.of(0, 5, Direction.DESC, "ID");
		var pageable = produtoRepo.findAll(page);
		log.info("Lista de Produtos {} produtos: {}", pageable.getMeta().getTotalPages(),pageable.getData().toString());
	}

}
