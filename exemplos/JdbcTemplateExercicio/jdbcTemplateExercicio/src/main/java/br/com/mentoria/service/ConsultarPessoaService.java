package br.com.mentoria.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mentoria.dao.PessoaRepository;
import br.com.mentoria.model.Pessoa;

public class ConsultarPessoaService {

	@Autowired
	private PessoaRepository repo;
	
	
	public Pessoa findById(Integer id) {
		return null;
	}
	
}
