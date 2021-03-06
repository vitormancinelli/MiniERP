package com.example.entity;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Pedido")
public class Pedido {
	
	public Pedido() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private int numeroPedido;
	
	@Transient
	private List<ItemPagamento> listaPagamento;
	
	@Transient
	private List<ItemProduto> listaProdutos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getJustificativaCancelamento() {
		return justificativaCancelamento;
	}

	public void setJustificativaCancelamento(String justificativaCancelamento) {
		this.justificativaCancelamento = justificativaCancelamento;
	}

	public int getCancelado() {
		return cancelado;
	}

	public void setCancelado(int cancelado) {
		this.cancelado = cancelado;
	}

	public List<ItemPagamento> getListaPagamento() {
		if (listaPagamento == null || listaPagamento.isEmpty()) {
			listaPagamento = new ArrayList<>();
		}
		return listaPagamento;
	}

	public void setListaPagamento(List<ItemPagamento> listaPagamento) {
		this.listaPagamento = listaPagamento;
	}

	public List<ItemProduto> getListaProdutos() {
		if (listaProdutos == null || listaProdutos.isEmpty()) {
			listaProdutos = new ArrayList<>();
		}
		return listaProdutos;
	}

	public void setListaProdutos(List<ItemProduto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
}
