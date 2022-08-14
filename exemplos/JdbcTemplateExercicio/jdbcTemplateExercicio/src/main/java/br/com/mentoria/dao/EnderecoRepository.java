package br.com.mentoria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.mentoria.dao.interfaces.CrudBasicoDAO;
import br.com.mentoria.dao.interfaces.Sequencial;
import br.com.mentoria.model.BaseEntity;
import br.com.mentoria.model.Cidade;
import br.com.mentoria.model.Endereco;

@Repository
public class EnderecoRepository implements CrudBasicoDAO<Endereco>, Sequencial<Endereco> {

	private static String ENDERECO_ID = "ID";
	private static String ENDERECO_LOGRADOURO = "LOGRADOURO";
	private static String ENDERECO_NUMERO = "NUMERO";
	private static String ENDERECO_COMPLEMENTO = "COMPLEMENTO";
	private static String ENDERECO_BAIRRO = "CEP";
	private static String ENDERECO_CEP = "CEP";
	private static String ENDERECO_ID_CIDADE = "ID_CIDADE";
	
	@Autowired
	private JdbcTemplate repo;
	
	@Autowired
	public EnderecoRepository(JdbcTemplate jdbcTemplate) {
		this.repo = jdbcTemplate;
	}
	
	@Override
	public Optional<Endereco> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Endereco> findEnderecoByPessoaId(int id){
		List<Endereco> enderecos = new ArrayList<Endereco>();
		repo.queryForObject("SELECT ENDERECO.ID, ENDERECO.LOGRADOURO, ENDERECO.NUMERO, ENDERECO.COMPLEMENTO, ENDERECO.BAIRRO, ENDERECO.CEP, ENDERECO.ID_CIDADE FROM ENDERECO WHERE ID_PESSOA=? ", new RowMapper<List<Endereco>>(){

			
			
			@Override
			public List<Endereco> mapRow(ResultSet rs, int rowNum) throws SQLException {
				var endereco = new Endereco(rs.getInt(ENDERECO_ID), 
						rs.getString(ENDERECO_LOGRADOURO), 
						rs.getString(ENDERECO_NUMERO), 
						rs.getString(ENDERECO_COMPLEMENTO), 
						rs.getString(ENDERECO_BAIRRO), 
						rs.getString(ENDERECO_CEP), 
						id, 
						new Cidade(rs.getInt(ENDERECO_ID_CIDADE)));
				
				enderecos.add(endereco);
				return null;
			}
			
		}, id);
		return enderecos;
	}

	@Override
	public Endereco insert(Endereco entity) {
		var endereco = this.nextValue(entity);
		repo.update("insert into ENDERECO (id, logradouro, numero, complemento, bairro, cep, id_pessoa, id_cidade) values (?,?,?,?,?,?,?, ?)", 
				endereco.getId(),endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(), endereco.getBairro(), endereco.getCep(), endereco.getPessoaId(), endereco.getCidade().getId());
		return endereco;
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
	public Endereco nextValue(Endereco entity) {
		// TODO Auto-generated method stub
		return repo.queryForObject("select nextval(?)", new RowMapper<Endereco>() {

			@Override
			public Endereco mapRow(ResultSet rs, int rowNum) throws SQLException {
				entity.setId(rs.getInt(1));
				return entity;
			}
			
		}, "SEQ_" + BaseEntity.getEntityName(entity) + "_id");
	}
}
