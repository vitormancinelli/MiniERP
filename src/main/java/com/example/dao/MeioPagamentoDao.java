package com.example.dao;

import java.util.List;

import com.example.entity.MeioPagamento;
import com.example.entity.TipoMoeda;

public interface MeioPagamentoDao {
	
	MeioPagamento findById(Long id) throws Exception;
	
	MeioPagamento findByNome(String nome) throws Exception;
	
	MeioPagamento findByTipoMoeda(TipoMoeda tipoMoeda) throws Exception;
	
	MeioPagamento findByExample(MeioPagamento meioPagamento) throws Exception;
	
	List<MeioPagamento> findAll() throws Exception;
	
	void persist(MeioPagamento itemProduto) throws Exception;
	
	void merge(MeioPagamento itemProduto) throws Exception;
	
	void removeByExample(MeioPagamento itemProduto) throws Exception;
	
	void removeById(Long id) throws Exception;

}
