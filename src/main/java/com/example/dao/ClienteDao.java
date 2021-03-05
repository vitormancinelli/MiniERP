package com.example.dao;

import java.util.List;

import com.example.entity.Cliente;

public interface ClienteDao {
	
	List<Cliente> findAll() throws Exception;
	
	Cliente findById(Long id) throws Exception;
	
	Cliente findByCpf(String cpf) throws Exception;
	
	Cliente findByCpfAndId(String cpf, Long id) throws Exception;
	
	Cliente findByExample(Cliente cliente) throws Exception;
	
	void merge(Cliente cliente) throws Exception;
	
	void persist(Cliente cliente) throws Exception;
	
	void removeByExample(Cliente cliente) throws Exception;
	
	void removeById(Long id) throws Exception;
	
	void removeByCpf(String cpf) throws Exception;

}
