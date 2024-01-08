package com.mercadinholivre.mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadinholivre.mercado.model.Lojinha;
import java.util.List;

@Repository
public interface LojinhaRepository extends JpaRepository<Lojinha, Long>{
    public List<Lojinha> findAllByNomeContainingIgnoreCase (String nome);
}
