package br.com.mentoria.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mentoria.dao.interfaces.InsertPorLoteDAO;
import br.com.mentoria.dao.interfaces.PagingAndSortingDAO;
import br.com.mentoria.dao.interfaces.Sequencial;
import br.com.mentoria.enumerator.Categoria;
import br.com.mentoria.model.BaseEntity;
import br.com.mentoria.model.Produto;

@Repository
public class ProdutoRepository implements Sequencial<Produto>, InsertPorLoteDAO<Produto>, PagingAndSortingDAO<Produto> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Page<Produto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		Order order = pageable.getSort().isEmpty() ? Order.by("ID") : pageable.getSort().toList().get(0);
		var orderBy = order.getProperty() + " " + order.getDirection().name();
		var count = count();		
		var produtos = parseMapToList(jdbcTemplate.queryForList("SELECT * FROM PRODUTO ORDER BY " + orderBy + " LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset()));
		
		
		return new PageImpl<Produto>(produtos, pageable, count);
		
	}

	@Override
	public Iterable<Produto> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM PRODUTO", Integer.class);
	}
	
	@Transactional
	@Override
	public void insertLote(List<Produto> list) {
		
		jdbcTemplate.batchUpdate("INSERT INTO PRODUTO (ID, NOME, PRECO, CATEGORIA, URL_IMAGEM) VALUES (?,?,?,?,?)", new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				var seq = nextValue(list.get(i));
				ps.setInt(1, seq.getId());
				ps.setString(2, list.get(i).getNome());
				ps.setDouble(3, list.get(i).getPreco());
				ps.setInt(4, list.get(i).getCategoria().getId());
				ps.setString(5, list.get(i).getPhotoUrl());
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
		
	}

	@Override
	public Produto nextValue(Produto entity) {
		return jdbcTemplate.queryForObject("select nextval(?)", new RowMapper<Produto>() {

			@Override
			public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
				 entity.setId(rs.getInt(1));
				 return entity;
			}
			
		}, "SEQ_" + BaseEntity.getEntityName(entity) + "_id");
	}

	private List<Produto> parseMapToList(List<Map<String, Object>> rows){
		final List<Produto> produtos = new ArrayList<Produto>();
		for(Map row: rows) {
			var id = (Integer)row.get("ID");
			var nome = (String) row.get("NOME");
			var preco =  ((BigDecimal)row.get("PRECO")).doubleValue();
			//var categoria = Integer.parseInt((String) row.get("CATEGORIA"));
			Produto p = new Produto(id, nome, preco, Categoria.books);
			produtos.add(p);
		}
		return produtos;
	}

}
