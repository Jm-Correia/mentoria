package br.com.mentoria.dao.interfaces;

import java.util.Optional;

import br.com.mentoria.model.BaseEntity;

public interface CrudBasicoDAO<T extends BaseEntity<?>>{

	public Optional<T> findById(int id);
	public T insert(T entity);
	public Optional<T> update(T entity);
	public void deleteById(int id);
	
}
