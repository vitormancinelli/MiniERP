package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ItemProduto")
public class ItemProduto {

	public ItemProduto() {}
	
	public ItemProduto(Produto produto, Pedido pedido) {
		this.produto = produto;
		this.pedido = pedido;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private Produto produto;
	
	@Column
	private Pedido pedido;
	
	@Column
	private int cancelado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		if (produto == null) {
			produto = new Produto();
		}
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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

	public int getCancelado() {
		return cancelado;
	}

	public void setCancelado(int cancelado) {
		this.cancelado = cancelado;
	}
	
}
