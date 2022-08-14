package br.com.mentoria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.mentoria.dao.interfaces.CrudBasicoDAO;
import br.com.mentoria.dao.interfaces.Sequencial;
import br.com.mentoria.enumerator.TipoPessoa;
import br.com.mentoria.model.BaseEntity;
import br.com.mentoria.model.Pessoa;


@Repository
public class PessoaRepository implements CrudBasicoDAO<Pessoa>, Sequencial<Pessoa> {

	private static String PESSOA_NOME = "nome";
	private static String PESSOA_EMAIL= "email";
	private static String PESSOA_CPF_OR_CNPJ = "cpfOuCnpj";
	private static String TIPO_PESSOA = "tipo";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	

	@Override
	public Optional<Pessoa> findById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT PESSOA.nome, PESSOA.email, PESSOA.cpfOuCnpj, PESSOA.tipo FROM PESSOA WHERE id=?", new RowMapper<Optional<Pessoa>>() {

			@Override
			public Optional<Pessoa> mapRow(ResultSet rs, int rowNum) throws SQLException {
				var p = new Pessoa(id, 
						rs.getString(PESSOA_NOME), 
						rs.getString(PESSOA_EMAIL), 
						rs.getString(PESSOA_CPF_OR_CNPJ), 
						rs.getInt(TIPO_PESSOA));
				
				return Optional.of(p);
			}

			
			
		}, id);
	}

	@Override
	public Pessoa insert(Pessoa entity) {
		var pessoa = nextValue(entity);
		jdbcTemplate.update("insert into PESSOA (id,nome, email, cpfOuCnpj, tipo) values (?,?,?,?,?)",
				pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getCpfOuCnpj(), TipoPessoa.getId(pessoa.getTipo()));
		return pessoa;
		
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
	public Pessoa nextValue(Pessoa entity) {
		
		return jdbcTemplate.queryForObject("select nextval(?)", new RowMapper<Pessoa>() {

			@Override
			public Pessoa mapRow(ResultSet rs, int rowNum) throws SQLException {
				 entity.setId(rs.getInt(1));
				 return entity;
			}
			
		}, "SEQ_" + BaseEntity.getEntityName(entity) + "_id");
		
	}

}
