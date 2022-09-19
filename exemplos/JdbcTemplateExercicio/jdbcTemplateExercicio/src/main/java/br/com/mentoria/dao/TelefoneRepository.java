package br.com.mentoria.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.mentoria.dao.interfaces.CrudBasicoDAO;
import br.com.mentoria.model.Telefone;

@Repository
public class TelefoneRepository implements CrudBasicoDAO<Telefone>  {

	@Override
	public Optional<Telefone> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefone insert(Telefone entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Telefone> update(Telefone entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}
