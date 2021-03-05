package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

	public Cliente() {}
	
	public Cliente(String nome, int cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 60)
	private String nome;
	
	@Column(length = 11)
	private int cpf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
