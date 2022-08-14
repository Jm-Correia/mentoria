package br.com.mentoria.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mentoria.dao.interfaces.InsertPorLoteDAO;
import br.com.mentoria.model.Estado;

@Repository
public class EstadoRepository implements InsertPorLoteDAO<Estado> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertLote(List<Estado> list) {
		// TODO Auto-generated method stub
		jdbcTemplate.batchUpdate("insert into Estado (id, nome) values (?,?)", new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1,  list.get(i).getId());
				ps.setString(2,  list.get(i).getNome());
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
	}



}
