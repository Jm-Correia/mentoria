package br.com.mentoria.dao.interfaces;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import br.com.mentoria.helper.Pagination;
import br.com.mentoria.model.BaseEntity;

public interface PagingAndSortingDAO<T extends BaseEntity<?>> {

	Pagination<T> findAll(Pageable pageable);
	Iterable<T> findAll(Sort sort);
	int count();
}
