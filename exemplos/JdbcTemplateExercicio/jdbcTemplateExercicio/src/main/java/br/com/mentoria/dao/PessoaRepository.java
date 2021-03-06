package br.com.mentoria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.mentoria.enumerator.TipoPessoa;
import br.com.mentoria.model.Pessoa;


@Repository
public class PessoaRepository implements GenericDao<Pessoa> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Pessoa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pessoa> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Pessoa entity) {
		
		jdbcTemplate.update("insert into PESSOA (id,nome, email, cpfOuCnpj, tipo) values (?,?,?,?,?)",
				entity.getId(), entity.getNome(), entity.getEmail(), entity.getCpfOuCnpj(), TipoPessoa.getId(entity.getTipo()));
		
	}

	@Override
	public Optional<Pessoa> update(Pessoa entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertLote(List<Pessoa> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int nextValue() {
		var seq = jdbcTemplate.queryForObject("select nextval(?)", new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1);
			}
			
		}, "SEQ_" + Pessoa.entityName + "_id");
		return seq;
	}

}
