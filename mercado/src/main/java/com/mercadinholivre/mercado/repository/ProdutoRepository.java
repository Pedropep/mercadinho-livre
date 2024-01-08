package com.mercadinholivre.mercado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadinholivre.mercado.model.Categoria;
import com.mercadinholivre.mercado.model.Lojinha;
import com.mercadinholivre.mercado.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    public List<Produto> findByNomeContainingIgnoreCase(String nome);
	public List<Produto> findByCategoria(Categoria categoria);
	public List<Produto> findByLoja(Lojinha loja);
	

}
