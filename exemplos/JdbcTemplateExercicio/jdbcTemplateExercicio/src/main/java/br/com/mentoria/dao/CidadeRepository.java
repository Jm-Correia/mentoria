package br.com.mentoria.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mentoria.dao.interfaces.InsertPorLoteDAO;
import br.com.mentoria.model.Cidade;


@Repository
public class CidadeRepository implements InsertPorLoteDAO<Cidade> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertLote(List<Cidade> list) {
		// TODO Auto-generated method stub
		jdbcTemplate.batchUpdate("INSERT INTO CIDADE (ID, NOME, ID_ESTADO) VALUES (?,?,?)", new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, list.get(i).getId());
				ps.setString(2, list.get(i).getNome());
				ps.setInt(3, list.get(i).getEstadoId());
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
	}


}
