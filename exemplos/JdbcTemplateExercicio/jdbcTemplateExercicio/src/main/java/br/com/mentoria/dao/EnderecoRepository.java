package br.com.mentoria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.mentoria.model.Endereco;
import br.com.mentoria.model.Pessoa;

@Repository
public class EnderecoRepository implements GenericDao<Endereco> {

	
	private JdbcTemplate repo;
	
	@Autowired
	public EnderecoRepository(JdbcTemplate jdbcTemplate) {
		this.repo = jdbcTemplate;
	}
	
	@Override
	public List<Endereco> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Endereco> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Endereco entity) {
		
		repo.update("insert into ENDERECO (id, logradouro, numero, complemento, bairro, cep, id_pessoa) values (?,?,?,?,?,?,?)", 
				nextValue(),entity.getLogradouro(), entity.getNumero(), entity.getComplemento(), entity.getBairro(), entity.getCep(), entity.getPessoaId());
		
	}

	@Override
	public Optional<Endereco> update(Endereco entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertLote(List<Endereco> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int nextValue() {
		var seq = repo.queryForObject("select nextval(?)", new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1);
			}
			
		}, "SEQ_" + Endereco.entityName + "_id");
		return seq;
	}

}
