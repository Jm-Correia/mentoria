package br.com.mentoria.dao.interfaces;

import br.com.mentoria.model.BaseEntity;

public interface Sequencial<T extends BaseEntity<?>> {
	
	public T nextValue(T entity);
	
}
