package br.com.mentoria.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mentoria.dao.EnderecoRepository;
import br.com.mentoria.dao.PessoaRepository;
import br.com.mentoria.model.Endereco;
import br.com.mentoria.model.Pessoa;

@Service
public class CadastrarClienteService {

	private Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass()); 
	
	
	@Autowired
	private PessoaRepository pessoaRepo;
	
	@Autowired
	private EnderecoRepository enderecoRepo;
	
		
	@Transactional
	public void cadastrarPessoa(Pessoa cliente, Endereco end) {
		log.info("Inserindo new Cliente");
		cliente = pessoaRepo.insert(cliente);
		log.info("Setando clienteID no endereco");
		end.setPessoaId(cliente.getId());
		log.info("Inserindo Enderco do cliente: " + cliente.getId());
		enderecoRepo.insert(end);
		log.info("Cadastro Efetuado com Sucesso.");
	}
	
}
