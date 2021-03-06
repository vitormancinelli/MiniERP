package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Cliente;

@Service
public interface ClienteService {
	
	List<Cliente> findAll() throws Exception;
	
	Optional<Cliente> findById(Long id) throws Exception;
	
	List<Cliente> findByCpf(String cpf) throws Exception;
	
	List<Cliente> findByRg(String rg) throws Exception;
	
	Cliente save(Cliente cliente) throws Exception;
	
	Optional<Cliente> update(Cliente cliente, Long id) throws Exception;
	
	void deleteById(Long id) throws Exception;
	
	long count() throws Exception;

}
