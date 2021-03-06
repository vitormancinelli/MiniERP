package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.service.ClienteService;
import com.example.entity.Cliente;
import com.example.dao.ClienteDao;

public class ClienteServiceImpl implements ClienteService {

	Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public List<Cliente> findAll() {
		try {
			return clienteDao.findAll();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public Optional<Cliente> findById(Long id) throws Exception {
		try {
			if (id != null) {
				return clienteDao.findById(id);
			} else {
				throw new Exception("Valor inválido, necessário um id válido, para realizar a busca");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<Cliente> findByCpf(String cpf) throws Exception {
		try {
			if (cpf != null && !cpf.isEmpty()) {
				return clienteDao.findByCpf(cpf);
			} else {
				throw new Exception("Valor inválido, necessário um cpf válido, para realizar a busca");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<Cliente> findByRg(String rg) throws Exception {
		try {
			if (rg != null && !rg.isEmpty() && rg.length() == 9) {
				return clienteDao.findByRg(rg);
			} else {
				throw new Exception("Valo inválido, necessário um rg válido, para realizar a busca");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	@Override
	public Cliente save(Cliente cliente) throws Exception {
		try {
			if(validate(cliente)) {
				return clienteDao.save(cliente);
			} else {
				throw new Exception("Valor inválido, necessário um cliente válido, para realizar o save");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public Optional<Cliente> update(Cliente cliente, Long id) throws Exception {
		try {
			if(clienteDao.existsById(id)) {
				cliente.setId(id);
				if(validate(cliente)) {
					return Optional.of(clienteDao.save(cliente));
				} else {
					throw new Exception("Valor inválido, necessário um cliente válido, para realizar o update");
				}
			} else {
				throw new Exception("Id não encontrado!");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void deleteById(Long id) throws Exception {
		try {
			if(id != null) {
				if(clienteDao.existsById(id)) {
					clienteDao.deleteById(id);
				} else {
					throw new Exception("Cliente não achado, id não cadastrado no banco");
				}
			} else {
				throw new Exception("Valor inválido, necessário um id válido, para realizar o delete");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public long count() throws Exception {
		try {
			return clienteDao.count();
		} catch(Exception e) {
			throw e;
		}
	}
	
	private boolean validate(Cliente cliente) {
		boolean flag = true;
		if (cliente.getCpf() == null || cliente.getCpf().isEmpty() || cliente.getCpf().length() != 11) flag=false;
		if (cliente.getRg() == null || cliente.getRg().isEmpty() || cliente.getRg().length() != 9) flag=false;
		if (cliente.getNome() == null || cliente.getNome().isEmpty() || cliente.getNome().length() > 60 || cliente.getNome().length() < 1) flag=false;
		return flag;
	}

}
