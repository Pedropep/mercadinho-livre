package com.mercadinholivre.mercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadinholivre.mercado.model.Categoria;
import com.mercadinholivre.mercado.model.Lojinha;
import com.mercadinholivre.mercado.model.Produto;
import com.mercadinholivre.mercado.repository.CategoriaRepository;
import com.mercadinholivre.mercado.repository.LojinhaRepository;
import com.mercadinholivre.mercado.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LojinhaRepository lojaRepository;
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}

	public List<Produto> findByName(String nome) {
		return produtoRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	public List<Produto> findByLoja(Long id){
		Optional<Lojinha> b = lojaRepository.findById(id);
		
		if(b.isPresent()) {
			return produtoRepository.findByLoja(b.get());
		}
		else {
			List<Produto> listEmpty = new ArrayList<>();
			return  listEmpty;
		}
	}
	
	public void deleteProduto(long id) {
		produtoRepository.deleteById(id);
	}

	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<Produto> findByCategoria(Long id){
		Optional<Categoria> b = categoriaRepository.findById(id);
		
		if(b.isPresent()) {
			return produtoRepository.findByCategoria(b.get());
		}
		else {
			List<Produto> listEmpty = new ArrayList<>();
			return  listEmpty;
		}
	}
}
