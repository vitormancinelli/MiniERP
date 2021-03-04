package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ItemPagamento")
public class ItemPagamento {
	
	public ItemPagamento() {}
	
	public ItemPagamento(MeioPagamento meioPagamento, Double valor) {
		this.meioPagamento = meioPagamento;
		this.valor = valor;
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column()
	private MeioPagamento meioPagamento;
	
	@Column()
	private Pedido pedido;
	
	@Column()
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MeioPagamento getMeioPagamento() {
		if (meioPagamento == null) {
			meioPagamento = new MeioPagamento();
		}
		return meioPagamento;
	}

	public void setMeioPagamento(MeioPagamento meioPagamento) {
		this.meioPagamento = meioPagamento;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
