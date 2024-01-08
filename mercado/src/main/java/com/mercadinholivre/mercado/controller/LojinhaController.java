package com.mercadinholivre.mercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadinholivre.mercado.model.Lojinha;
import com.mercadinholivre.mercado.service.LojinhaService;

@RestController
@RequestMapping("/loja")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class LojinhaController {
	
	@Autowired
	private LojinhaService service;
	
	@GetMapping
	public ResponseEntity<List<Lojinha>> findAll(){
		return new ResponseEntity<List<Lojinha>>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Lojinha> findById(@PathVariable Long id){
		return new ResponseEntity<Lojinha>(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/nome-loja/{nome}")
	public ResponseEntity<List<Lojinha>> findByNome(@PathVariable String nome){
		return new ResponseEntity<List<Lojinha>>(service.findByName(nome), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Lojinha> postLoja(@Validated @RequestBody Lojinha loja){
		return new ResponseEntity<Lojinha>(service.postLoja(loja), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Lojinha> putLoja(@Validated @RequestBody Lojinha loja){
		return new ResponseEntity<Lojinha>(service.postLoja(loja), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleta-loja/{id}")
	public void deleteLoja(@PathVariable Long id) {
		service.deleteById(id);
	}
}
