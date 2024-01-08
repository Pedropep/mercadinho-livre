package com.mercadinholivre.mercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mercadinholivre.mercado.model.Lojinha;
import com.mercadinholivre.mercado.repository.LojinhaRepository;

@Service
public class LojinhaService {
    
    @Autowired
    private LojinhaRepository repository;

    public List<Lojinha> findAll(){
        return repository.findAll();
    }
    
    public List<Lojinha> findByName(String nome){
		return repository.findAllByNomeContainingIgnoreCase(nome);
	}
    
    public Lojinha findById(Long id){
        return repository.findById(id)
        .map(resp ->(resp))
        .orElse(null);
    } 
    
    public Lojinha postLoja (Lojinha loja){
		return repository.save(loja);
	}
    
    public ResponseEntity<Lojinha> putLoja(@RequestBody Lojinha loja){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(loja));	
	}
    
    public void deleteById(@PathVariable Long id) {
		repository.findById(id);
			
	}


}
