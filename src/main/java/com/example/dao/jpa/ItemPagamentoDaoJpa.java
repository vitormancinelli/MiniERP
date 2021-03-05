package com.example.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dao.ItemPagamentoDao;
import com.example.entity.ItemPagamento;
import com.example.entity.Pedido;
import com.example.entity.MeioPagamento;

public class ItemPagamentoDaoJpa implements ItemPagamentoDao {
	
	private static ItemPagamentoDaoJpa instance;
	protected EntityManager entityManager;

	public static ItemPagamentoDaoJpa getInstance() {
		if (instance == null) {
			instance = new ItemPagamentoDaoJpa();
		}
		return instance;
	}

	private ItemPagamentoDaoJpa() {
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
	public ItemPagamento findById(final Long id) throws Exception {
		try {
			if (id != null) {
				return entityManager.find(ItemPagamento.class, id);
			} else {
				throw new Exception("Valor inválido, necessário um Id, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public ItemPagamento findByPedido(final Pedido pedido) throws Exception {
		try {
			if (pedido != null) {
				return entityManager.find(ItemPagamento.class, pedido);
			} else {
				throw new Exception("Valor inválido, necessário um pedido, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public ItemPagamento findByMeioPagamento(final MeioPagamento meioPagamento) throws Exception {
		try {
			if (meioPagamento != null) {
				return entityManager.find(ItemPagamento.class, meioPagamento);
			} else {
				throw new Exception("Valor inválido, necessário um meioPagamento, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public ItemPagamento findByValor(final Double valor) throws Exception {
		try {
			if (valor != null) {
				return entityManager.find(ItemPagamento.class, valor);
			} else {
				throw new Exception("Valor inválido, necessário um valor, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public ItemPagamento findByExample(final ItemPagamento itemPagamento) throws Exception {
		try {
			if (itemPagamento != null) {
				return entityManager.find(ItemPagamento.class, itemPagamento);
			} else {
				throw new Exception("Valor inválido, necessário um itemPagamento, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ItemPagamento> findAll() throws Exception {
		try {
			return entityManager.createQuery("FROM " + ItemPagamento.class.getName()).getResultList();
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void persist(ItemPagamento itemPagamento) throws Exception {
		try {
			if (itemPagamento != null) {
				entityManager.getTransaction().begin();
				entityManager.persist(itemPagamento);
				entityManager.getTransaction().commit();
			} else {
				throw new Exception("Valor inválido, necessário um ItemPagamento, para que o persist possa ser realizado");
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void merge(ItemPagamento itemPagamento) throws Exception {
		try {
			if (itemPagamento != null) {
				entityManager.getTransaction().begin();
				entityManager.merge(itemPagamento);
				entityManager.getTransaction().commit();
			} else {
				throw new Exception("Valor inválido, necessário um ItemPagamento, para que o merge possa ser realizado");
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	}
	
	private void remove(ItemPagamento itemPagamento) throws Exception {
		try {
			entityManager.getTransaction().begin();
			itemPagamento = entityManager.find(ItemPagamento.class, itemPagamento.getId());
			entityManager.remove(itemPagamento);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void removeByExample(ItemPagamento itemPagamento) throws Exception {
		try {
			if (itemPagamento != null) {
				remove(itemPagamento);
			} else {
				throw new Exception("Valor inválido, necessário um ItemPagamento, para que o remove possa ser realizado");
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
				ItemPagamento itemPagamento = findById(id);
				remove(itemPagamento);
			} else {
				throw new Exception("Valor inválido, necessário um Id, para que o remove possa ser realizado");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
}
