package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {
	
	public Venda() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(name = "cliente")
	private Cliente cliente;
	
	@Column(name = "pedido")
	private Pedido pedido;
	
	@Column(name = "cancelado")
	private int cancelado;
	
	@Column(name = "justificativa", length = 60)
	private String justificativa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCancelado() {
		return cancelado;
	}

	public void setCancelado(int cancelado) {
		this.cancelado = cancelado;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Cliente getCliente() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido getPedido() {
		if (pedido == null) {
			pedido = new Pedido();
		}
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
