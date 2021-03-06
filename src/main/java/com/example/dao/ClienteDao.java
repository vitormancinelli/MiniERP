package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByCpf(String cpf);
	
	List<Cliente> findByRg(String rg);
	
}
