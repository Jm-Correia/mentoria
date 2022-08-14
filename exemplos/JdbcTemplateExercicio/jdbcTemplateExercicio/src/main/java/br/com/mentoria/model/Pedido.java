package br.com.mentoria.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mentoria.enumerator.StatusPedido;

@SuppressWarnings("serial")
public class Pedido extends BaseEntity<Integer> {

	private Integer clienteId;
	
	private LocalDateTime instante = LocalDateTime.now();
	
	private StatusPedido status;
	
	private List<ItemPerdido> items = new ArrayList<>();
	
	

	public Pedido(Integer clienteId, List<ItemPerdido> items) {
		super();
		this.clienteId = clienteId;
		this.status = StatusPedido.SOLICITADO;
		this.items = items;
	}

	public Pedido(Integer id, LocalDateTime instante, Integer clienteId, StatusPedido status) {
		super();
		this.id = id;
		this.instante = instante;
		this.clienteId = clienteId;
		this.status = status;
	}

	public Pedido(Integer id, Integer clienteId, StatusPedido status) {
		super();
		this.id = id;
		this.clienteId = clienteId;
		this.status = status;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public LocalDateTime getInstante() {
		return instante;
	}

	public List<ItemPerdido> getItems() {
		return items;
	}

	public Integer getId() {
		return id;
	}
	
	
	
	
}
