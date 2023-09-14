package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Produto;
import com.projetojpa.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	//Método para buscar todos os Produtos
	public List<Produto> buscaTodosProdutos(){
		return produtoRepository.findAll();
	}
	// Método para buscar produtos por código
	public  Produto  buscaProdutoId(Long id) {
		Optional <Produto> produto = produtoRepository.findById(id);
		return produto.orElse(null);
	}
	//Método para salvar os produtos
	public Produto salvaProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	// Método para alterar os dados do  produto
	public Produto alterarProduto(Long id, Produto alterarProd) {
		Optional <Produto> existeProduto = produtoRepository.findById(id);
		if(existeProduto.isPresent()) {
			alterarProd.setId(id);
			return produtoRepository.save(alterarProd);
		}
		return null;
	}
	//Método para excluir dados
	public boolean apagaProduto(Long id) {
		Optional <Produto> existeProduto = produtoRepository.findById(id);
		if(existeProduto.isPresent()) {
			produtoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}


