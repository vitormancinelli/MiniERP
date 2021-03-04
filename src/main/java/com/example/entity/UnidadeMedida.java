package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UnidadeMedida")
public class UnidadeMedida {
	
	public UnidadeMedida() {}
	
	public UnidadeMedida(String nome) {
		this.nome = nome;
	}

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 60)
	private String nome;
	
	@Column(length = 60)
	private String abreviacao;

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
	
}
