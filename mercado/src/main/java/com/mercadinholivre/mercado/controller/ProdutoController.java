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

import com.mercadinholivre.mercado.model.Produto;
import com.mercadinholivre.mercado.service.ProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProdutoController {
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(service.findByName(nome));	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		return service.findById(id).isPresent() ? ResponseEntity.status(HttpStatus.OK).body(service.findById(id).get()) : 
			ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/loja/{id}")
	public ResponseEntity<List<Produto>> findByLoja(@PathVariable Long id){
		return service.findByLoja(id).isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
			ResponseEntity.status(HttpStatus.OK).body(service.findByLoja(id));
	}
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<List<Produto>> findByCategoria(@PathVariable Long id){
		return service.findByCategoria(id).isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
			ResponseEntity.status(HttpStatus.OK).body(service.findByCategoria(id));
	}
	
	@PostMapping
	public ResponseEntity<Produto> post (@Validated @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put (@Validated @RequestBody Produto produto){
		return ResponseEntity.ok(service.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		service.deleteProduto(id);
	}
}
