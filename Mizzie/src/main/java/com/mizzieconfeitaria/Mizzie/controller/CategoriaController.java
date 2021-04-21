package com.mizzieconfeitaria.Mizzie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mizzieconfeitaria.Mizzie.model.Categoria;
import com.mizzieconfeitaria.Mizzie.repository.CategoriaRepository;



@RestController
@RequestMapping("/categoria")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	public CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/busca/{nome}")
	public ResponseEntity<List<Categoria>> buscarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.buscaPorNome(nome));
	}
	
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> GetAllById(@PathVariable long codigo){
		return repository.findById(codigo)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Categoria> PostAll(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> PutAll(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
		
	}
	
	@DeleteMapping("/{codigo}")
	
	public void delete(@PathVariable long codigo) {
		repository.deleteById(codigo);
	}
	
	
}