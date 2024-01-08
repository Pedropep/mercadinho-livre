package com.mercadinholivre.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadinholivre.mercado.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    public Categoria findByNome(String nome);
}
