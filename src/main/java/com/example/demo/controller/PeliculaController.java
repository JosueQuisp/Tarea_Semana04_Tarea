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
import com.example.demo.entity.Pelicula;
import com.example.demo.service.PeliculaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
	
	@Autowired
	private PeliculaService peliculaService; 
	
	@GetMapping
	public ResponseEntity<List<Pelicula>> readAll(){
		try {
			List<Pelicula> peli= peliculaService.readAll(); 
			if (peli.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(peli, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Pelicula> create(@Valid @RequestBody Pelicula c){
		try {
			Pelicula pelis= peliculaService.create(c); 
			return new ResponseEntity<>(pelis, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pelicula> getpelicula(@PathVariable("id") Long id){
		Optional<Pelicula> pelis= peliculaService.read(id); 
		return pelis.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Pelicula> updatepelicula(@PathVariable("id") Long id, @Valid @RequestBody Pelicula pelicula){
		 Optional<Pelicula> existingpelicula = peliculaService.read(id);
	        if (existingpelicula.isPresent()) {
	            pelicula.setId(id);
	            return new ResponseEntity<>(peliculaService.update(pelicula), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletepelicula(@PathVariable("id") Long id) {
        try {
            peliculaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	

}
