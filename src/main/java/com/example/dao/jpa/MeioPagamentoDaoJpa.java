package com.example.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dao.MeioPagamentoDao;
import com.example.entity.MeioPagamento;
import com.example.entity.TipoMoeda;

public class MeioPagamentoDaoJpa implements MeioPagamentoDao {
	
	private static MeioPagamentoDaoJpa instance;
	protected EntityManager entityManager;

	public static MeioPagamentoDaoJpa getInstance() {
		if (instance == null) {
			instance = new MeioPagamentoDaoJpa();
		}
		return instance;
	}

	private MeioPagamentoDaoJpa() {
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
	public MeioPagamento findById(final Long id) throws Exception {
		try {
			if (id != null) {
				return entityManager.find(MeioPagamento.class, id);
			} else {
				throw new Exception("Valor inválido, necessário um Id, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public MeioPagamento findByNome(final String nome) throws Exception {
		try {
			if (nome != null && !nome.isEmpty()) {
				return entityManager.find(MeioPagamento.class, nome);
			} else {
				throw new Exception("Valor inválido, necessário um Nome, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public MeioPagamento findByTipoMoeda(final TipoMoeda tipoMoeda) throws Exception {
		try {
			if (tipoMoeda != null) {
				return entityManager.find(MeioPagamento.class, tipoMoeda);
			} else {
				throw new Exception("Valor inválido, necessário um TipoMoeda, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public MeioPagamento findByExample(final MeioPagamento meioPagamento) throws Exception {
		try {
			if (meioPagamento != null) {
				return entityManager.find(MeioPagamento.class, meioPagamento);
			} else {
				throw new Exception("Valor inválido, necessário um MeioPagamento, para que a busca possa ser realizada");
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MeioPagamento> findAll() throws Exception {
		try {
			return entityManager.createQuery("FROM " + MeioPagamento.class.getName()).getResultList();
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void persist(MeioPagamento meioPagamento) throws Exception {
		try {
			if (meioPagamento != null) {
				entityManager.getTransaction().begin();
				entityManager.persist(meioPagamento);
				entityManager.getTransaction().commit();
			} else {
				throw new Exception("Valor inválido, necessário um MeioPagamento, para que o persist possa ser realizado");
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void merge(MeioPagamento meioPagamento) throws Exception {
		try {
			if (meioPagamento != null) {
				entityManager.getTransaction().begin();
				entityManager.merge(meioPagamento);
				entityManager.getTransaction().commit();
			} else {
				throw new Exception("Valor inválido, necessário um MeioPagamento, para que o merge possa ser realizado");
			}
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	}
	
	private void remove(MeioPagamento meioPagamento) throws Exception {
		try {
			entityManager.getTransaction().begin();
			meioPagamento = entityManager.find(MeioPagamento.class, meioPagamento.getId());
			entityManager.remove(meioPagamento);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void removeByExample(MeioPagamento meioPagamento) throws Exception {
		try {
			if (meioPagamento != null) {
				remove(meioPagamento);
			} else {
				throw new Exception("Valor inválido, necessário um MeioPagamento, para que o remove possa ser realizado");
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
				MeioPagamento meioPagamento = findById(id);
				remove(meioPagamento);
			} else {
				throw new Exception("Valor inválido, necessário um Id, para que o remove possa ser realizado");
			}
		} catch(Exception e) {
			throw e;
		}
	}
}
