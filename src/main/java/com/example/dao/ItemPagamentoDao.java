package com.example.dao;

import java.util.List;

import com.example.entity.ItemPagamento;
import com.example.entity.Pedido;
import com.example.entity.MeioPagamento;

public interface ItemPagamentoDao {
	
	ItemPagamento findById(Long id) throws Exception;
	
	ItemPagamento findByPedido(Pedido pedido) throws Exception;
	
	ItemPagamento findByMeioPagamento(MeioPagamento meioPagamento) throws Exception;
	
	ItemPagamento findByValor(Double valor) throws Exception;
	
	ItemPagamento findByExample(ItemPagamento itemPagamento) throws Exception;
	
	List<ItemPagamento> findAll() throws Exception;
	
	void merge(ItemPagamento itemPagamento) throws Exception;
	
	void persist(ItemPagamento itemPagamento) throws Exception;
	
	void removeByExample(ItemPagamento itemPagamento) throws Exception;
	
	void removeById(Long id) throws Exception;

}
