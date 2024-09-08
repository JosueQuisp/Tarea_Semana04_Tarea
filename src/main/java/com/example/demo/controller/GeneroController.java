package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Genero;
import com.example.demo.service.GeneroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/generos")

public class GeneroController {
	
	@Autowired
	private GeneroService generoService; 
	
	@GetMapping
	public ResponseEntity<List<Genero>> readAll(){
		try {
			List<Genero> gene= generoService.readAll(); 
			if (gene.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(gene, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Genero> create(@Valid @RequestBody Genero c){
		try {
			Genero gener= generoService.create(c); 
			return new ResponseEntity<>(gener, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genero> getgenero(@PathVariable("id") Long id){
		Optional<Genero> generos= generoService.read(id); 
		return generos.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Genero> updategenero(@PathVariable("id") Long id, @Valid @RequestBody Genero genero){
		 Optional<Genero> existingenero = generoService.read(id);
	        if (existingenero.isPresent()) {
	            genero.setId(id);
	            return new ResponseEntity<>(generoService.upadate(genero), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletegenero(@PathVariable("id") Long id) {
        try {
            generoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	

}
