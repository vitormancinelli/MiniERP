package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MeioPagamento")
public class MeioPagamento {

	public MeioPagamento() {}
	
	public MeioPagamento(String nome, TipoMoeda tipoMoeda) {
		this.nome = nome;
		this.tipoMoeda = tipoMoeda;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(length = 60)
	private String nome;
	
	@Column
	private TipoMoeda tipoMoeda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoMoeda getTipoMoeda() {
		if (tipoMoeda == null) {
			tipoMoeda = new TipoMoeda();
		}
		return tipoMoeda;
	}

	public void setTipoMoeda(TipoMoeda tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}
	
}
