package br.com.mentoria.repository;

import java.util.List;
import java.util.Optional;

public interface  GenericRepo<T> {

	public List<T> findAll();
	public Optional<T> findById(int id);
	public void insert(T entity);
	public Optional<T> update(T entity);
	public void deleteById(int id);
	
	
}
