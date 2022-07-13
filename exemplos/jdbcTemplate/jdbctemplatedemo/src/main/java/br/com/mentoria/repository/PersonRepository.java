package br.com.mentoria.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mentoria.model.Person;

@Repository
public class PersonRepository implements GenericRepo<Person> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person>{
		
		private String PERSON_ID = "ID";
		private String PERSON_NAME= "NAME";
		private String PERSON_LAST_NAME = "LASTNAME";

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Person(rs.getInt(PERSON_ID),
					rs.getString(PERSON_NAME),
					rs.getString(PERSON_LAST_NAME));
		}
		
	}

	@Override
	public List<Person> findAll() {
		List<Person> lista= jdbcTemplate.query("SELECT ID, NAME, LASTNAME FROM PERSON", new PersonRowMapper());
		
		//return jdbcTemplate.query("select p.id as ID, p.name as NAME, p.lastName as LASTNAME from person p", new PersonRowMapper());
		return lista;
	}

	@Override
	public Optional<Person> findById(int id) {
		return Optional
				.of(jdbcTemplate.queryForObject("select p.id as ID, p.name as NAME, p.lastName as LASTNAME from person p"
				+ " where id=?", new PersonRowMapper(), id));
	}

	@Override
	public void insert(Person entity) {
		jdbcTemplate.update("insert into person (id,name, lastName) values (?,?,?)",
				entity.getId(), entity.getName(), entity.getLastName());		
	}

	@Transactional
	@Override
	public Optional<Person> update(Person entity) {
		jdbcTemplate.update("update person set name=?, lastName=? where id=?",
				entity.getName(), entity.getLastName(), entity.getId());
		return this.findById(entity.getId());
	}

	@Override
	public void deleteById(int id) {
		jdbcTemplate.update("delete from person where id=?",
				id);
		
	}
	
	
	
}
