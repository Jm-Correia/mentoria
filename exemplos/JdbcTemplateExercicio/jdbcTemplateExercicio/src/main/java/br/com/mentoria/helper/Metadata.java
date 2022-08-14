package br.com.mentoria.helper;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Metadata {
	
	private Link links;
	private Integer pageAtual;
	private Integer totalPages;
	private Sort sorteable;
	private Pageable page;
	private String uri;
	
	public Metadata(Pageable page, Integer totalElements, String baseUri) {
		this.sorteable = page.getSort();
		this.totalPages = totalElements;
		this.pageAtual = page.getPageNumber()+1;
		this.page = page;
		this.uri = baseUri;
	}
	
	private void generateLinks(String uri) {
		var baseLink = String.format("/%s?", uri);
		
		links = new Link.LinkBuilder()
				.primeiro(baseLink, 1, this.page.getPageSize())
				.anterior(baseLink, this.pageAtual-1, this.page.getPageSize())
				.atual(baseLink, this.pageAtual, this.page.getPageSize())
				.proximo(baseLink, this.page.getPageNumber()+1, this.page.getPageSize())
				.ultimo(baseLink, (totalPages/this.page.getPageSize()), this.page.getPageSize())
				.build();
		
	}

	public Link getLinks() {
		this.generateLinks(uri);
		return links;
	}

	public Integer getPageAtual() {
		return pageAtual;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public Sort getSorteable() {
		return sorteable;
	}
	
	
	
	
}
