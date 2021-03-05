package com.example.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dao.ItemProdutoDao;
import com.example.entity.ItemPagamento;
import com.example.entity.ItemProduto;
import com.example.entity.Pedido;
import com.example.entity.Produto;

public class ItemProdutoDaoJpa implements ItemProdutoDao {

	private static ItemProdutoDaoJpa instance;
	protected EntityManager entityManager;

	public static ItemProdutoDaoJpa getInstance() {
		if (instance == null) {
			instance = new ItemProdutoDaoJpa();
		}
		return instance;
	}

	private ItemProdutoDaoJpa() {
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
	public ItemProduto findById(final Long id) throws Exception {
		try {
			if (id != null) {
				return entityManager.find(ItemProduto.class, id);
			} else {
				throw new Exception("Valor inválido, necessário um Id, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public ItemProduto findByProduto(final Produto produto) throws Exception {
		try {
			if (produto != null) {
				return entityManager.find(ItemProduto.class, produto);
			} else {
				throw new Exception("Valor inválido, necessário um Produto, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public ItemProduto findByPedido(final Pedido pedido) throws Exception {
		try {
			if (pedido != null) {
				return entityManager.find(ItemProduto.class, pedido);
			} else {
				throw new Exception("Valor inválido, necessário um Pedido, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public ItemProduto findByExample(final ItemProduto itemProduto) throws Exception {
		try {
			if (itemProduto != null) {
				return entityManager.find(ItemProduto.class, itemProduto);
			} else {
				throw new Exception("Valor inválido, necessário um ItemProduto, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ItemProduto> findAll() throws Exception {
		try {
			return entityManager.createQuery("FROM " + ItemProduto.class.getName()).getResultList();
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void persist(ItemProduto itemProduto) throws Exception {
		try {
			if (itemProduto != null) {
				entityManager.getTransaction().begin();
				entityManager.persist(itemProduto);
				entityManager.getTransaction().commit();
			} else {
				throw new Exception("Valor inválido, necessário um ItemProduto, para que o persist possa ser realizado");
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void merge(ItemProduto itemProduto) throws Exception {
		try {
			if (itemProduto != null) {
				entityManager.getTransaction().begin();
				entityManager.merge(itemProduto);
				entityManager.getTransaction().commit();
			} else {
				throw new Exception("Valor inválido, necessário um ItemProduto, para que o merge possa ser realizado");
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	}
	
	private void remove(ItemProduto itemProduto) throws Exception {
		try {
			entityManager.getTransaction().begin();
			itemProduto = entityManager.find(ItemProduto.class, itemProduto.getId());
			entityManager.remove(itemProduto);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void removeByExample(ItemProduto itemProduto) throws Exception {
		try {
			if (itemProduto != null) {
				remove(itemProduto);
			} else {
				throw new Exception("Valor inválido, necessário um ItemProduto, para que o remove possa ser realizado");
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
				ItemProduto itemProduto = findById(id);
				remove(itemProduto);
			} else {
				throw new Exception("Valor inválido, necessário um Id, para que o remove possa ser realizado");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
}
