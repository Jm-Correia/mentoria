package br.com.mentoria.helper;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Pagination<T> {

	@JsonAlias("data")
	private List<T> data;
	
	private Metadata meta;
	


	public Pagination(List<T> content, Pageable page, Integer totalElements, String uri){
		this.data = content;
		this.meta = new Metadata(page, totalElements, uri);
	}


	public List<T> getData() {
		return data;
	}


	public Metadata getMeta() {
		return meta;
	}


	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	
	
}
