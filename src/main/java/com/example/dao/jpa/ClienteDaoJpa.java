package com.example.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dao.ClienteDao;
import com.example.entity.Cliente;

public class ClienteDaoJpa implements ClienteDao {

	private static ClienteDaoJpa instance;
	protected EntityManager entityManager;

	public static ClienteDaoJpa getInstance() {
		if (instance == null) {
			instance = new ClienteDaoJpa();
		}
		return instance;
	}

	private ClienteDaoJpa() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	@Override
	public Cliente findById(final Long id) throws Exception {
		try {
			if (id != null) {
				return entityManager.find(Cliente.class, id);
			} else {
				throw new Exception("Valor inválido, necessário um Id, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public Cliente findByCpf(final String cpf) throws Exception {
		try {
			if (cpf != null && !cpf.isEmpty()) {
				return entityManager.find(Cliente.class, cpf);
			} else {
				throw new Exception("Valor inválido, necessário um Cpf, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public Cliente findByCpfAndId(final String cpf, final Long id) throws Exception {
		try {
			Cliente cliente = new Cliente();
			if (id != null && cpf != null && !cpf.isEmpty()) {
				cliente.setCpf(cpf);
				cliente.setId(id);
				return entityManager.find(Cliente.class, cliente);
			} else if (id == null && (cpf != null && !cpf.isEmpty())) {
				return findByCpf(cpf);
			} else if (id != null && (cpf == null || cpf.isEmpty())) {
				return findById(id);
			} else {
				throw new Exception("Valores inválidos, necessário um Cpf ou um Id, para que a busca possa ser realizada");
			}			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override 
	public Cliente findByExample(final Cliente cliente) throws Exception {
		try {
			if (cliente != null) {
				return entityManager.find(Cliente.class, cliente);
			} else {
				throw new Exception("Valor inválido, necessário um Cliente, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {
		try {
			return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void persist(Cliente cliente) throws Exception {
		try {
			if (cliente != null) {
				entityManager.getTransaction().begin();
				entityManager.persist(cliente);
				entityManager.getTransaction().commit();
			} else {
				throw new Exception("Valor inválido, necessário um Cliente, para que o persist possa ser realizado");
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void merge(Cliente cliente) throws Exception {
		try {
			if (cliente != null) {
				entityManager.getTransaction().begin();
				entityManager.merge(cliente);
				entityManager.getTransaction().commit();
			} else {
				throw new Exception("Valor inválido, necessário um Cliente, para que o merge possa ser realizado");
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	}
	
	private void remove(Cliente cliente) throws Exception {
		try {
			entityManager.getTransaction().begin();
			cliente = entityManager.find(Cliente.class, cliente.getId());
			entityManager.remove(cliente);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void removeByExample(Cliente cliente) throws Exception {
		try {
			if (cliente != null) {
				remove(cliente);
			} else {
				throw new Exception("Valor inválido, necessário um Cliente, para que o remove possa ser realizado");
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	}
	
	@Override
	public void removeById(final Long id) throws Exception {
		try {
			if (id != null) {
				Cliente cliente = findById(id);
				remove(cliente);
			} else {
				throw new Exception("Valor inválido, necessário um Id, para que o remove possa ser realizado");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void removeByCpf(final String cpf) throws Exception {
		try {
			if (cpf != null && !cpf.isEmpty()) {
				Cliente cliente = findByCpf(cpf);
				remove(cliente);
			} else {
				throw new Exception("Valor inválido, necessário um Cpf, para que o remove possa ser realizado");
			}
		} catch(Exception e) {
			throw e;
		}
	}
}
