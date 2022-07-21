package br.com.mentoria.model;

import java.time.LocalDateTime;

import br.com.mentoria.enumerator.StatusPedido;

public class TransacaoPedido {

	private LocalDateTime dtTransacao;
	private StatusPedido status;
	private Integer pedidoId;
	
	public TransacaoPedido(LocalDateTime dtTransacao, StatusPedido status, Integer pedidoId) {
		super();
		this.dtTransacao = dtTransacao;
		this.status = status;
		this.pedidoId = pedidoId;
	}

	public LocalDateTime getDtTransacao() {
		return dtTransacao;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public Integer getPedidoId() {
		return pedidoId;
	}
	
	
	
}
