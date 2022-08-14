package br.com.mentoria.helper;

public class Link {

	private final String primeiro;
	private final String anterior;
	private final String atual;
	private final String proximo;
	private final String ultimo;
	
	private Link(LinkBuilder builder) {
		this.anterior = builder.anterior;
		this.primeiro = builder.primeiro;
		this.atual = builder.atual;
		this.proximo = builder.proximo;
		this.ultimo = builder.ultimo;
	}
	
	

	public String getPrimeiro() {
		return primeiro;
	}



	public String getAnterior() {
		return anterior;
	}



	public String getAtual() {
		return atual;
	}



	public String getProximo() {
		return proximo;
	}



	public String getUltimo() {
		return ultimo;
	}



	public Link builder() {
		return this;
	}
	
	public static class LinkBuilder{
		private  String primeiro;
		private  String anterior;
		private  String atual;
		private  String proximo;
		private  String ultimo;
		
		public LinkBuilder primeiro(String uri, Integer page, Integer size) { 
			this.primeiro = String.format("%spage=%s&size=%s", uri, page, size);
			return this;
		}
		public LinkBuilder anterior(String uri, Integer page, Integer size) { 
			if(page < 0) {
				return this;
			}
			this.anterior = String.format("%spage=%s&size=%s", uri, page, size);
			return this;
		}
		public LinkBuilder atual(String uri, Integer page, Integer size) {
			if(page > size) {
				return this;
			}
			this.atual = String.format("%spage=%s&size=%s", uri, page, size);
			return this;
		}
		public LinkBuilder proximo(String uri, Integer page, Integer size) { 
			if(page+1 >= size) {
				return this;
			}
			this.proximo = String.format("%spage=%s&size=%s", uri, page, size);
			return this;
		}
		public LinkBuilder ultimo(String uri, Integer page, Integer size) { 
			this.ultimo = String.format("%spage=%s&size=%s", uri, page, size);
			return this;
		}
		
		public Link build() {
			Link link = new Link(this);
			return link;
		}
		
	}
	
	
	
	
}
