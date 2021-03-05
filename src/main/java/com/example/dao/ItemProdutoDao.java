package com.example.dao;

import com.example.entity.Produto;

import java.util.List;

import com.example.entity.ItemProduto;
import com.example.entity.Pedido;

public interface ItemProdutoDao {
	
	ItemProduto findById(Long id) throws Exception;
	
	ItemProduto findByProduto(Produto produto) throws Exception;
	
	ItemProduto findByPedido(Pedido pedido) throws Exception;
	
	ItemProduto findByExample(ItemProduto itemProduto) throws Exception;
	
	List<ItemProduto> findAll() throws Exception;
	
	void persist(ItemProduto itemProduto) throws Exception;
	
	void merge(ItemProduto itemProduto) throws Exception;
	
	void removeByExample(ItemProduto itemProduto) throws Exception;
	
	void removeById(Long id) throws Exception;

}
