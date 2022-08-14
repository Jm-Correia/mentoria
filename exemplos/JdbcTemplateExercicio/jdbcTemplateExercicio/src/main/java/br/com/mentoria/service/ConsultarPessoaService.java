package br.com.mentoria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mentoria.dao.EnderecoRepository;
import br.com.mentoria.dao.PessoaRepository;
import br.com.mentoria.model.Pessoa;

@Service
public class ConsultarPessoaService {

	@Autowired
	private PessoaRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepo;
	
	@Transactional
	public Pessoa findById(Integer id) {
		var pessoa = repo.findById(id).get();
		pessoa.setEnderecos(enderecoRepo.findEnderecoByPessoaId(id));
		return pessoa;
	}
	
}
