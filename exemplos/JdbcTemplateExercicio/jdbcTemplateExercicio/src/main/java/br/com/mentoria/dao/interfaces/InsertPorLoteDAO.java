package br.com.mentoria.dao.interfaces;

import java.util.List;

import br.com.mentoria.model.BaseEntity;

public interface InsertPorLoteDAO<T extends BaseEntity<?>> {
	
	public void insertLote(List<T> list);
	
}
