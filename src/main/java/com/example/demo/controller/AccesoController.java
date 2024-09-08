package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Acceso;
import com.example.demo.service.AccesoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/accesos")
public class AccesoController {
	
	@Autowired
	private AccesoService accesoService; 
	
	
	@GetMapping
	public ResponseEntity<List<Acceso>> readAll(){
		try {
			List<Acceso> accesos= accesoService.redAll(); 
			if (accesos.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(accesos, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	
	@PostMapping
	public ResponseEntity<Acceso> create(@Valid @RequestBody Acceso c){
		try {
			Acceso acesoss= accesoService.create(c); 
			return new ResponseEntity<>(acesoss, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Acceso> getAcceso(@PathVariable("id") Long id){
		Optional<Acceso> aces= accesoService.read(id); 
		return aces.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Acceso> updateAcceso(@PathVariable("id") Long id, @Valid @RequestBody Acceso acceso){
		 Optional<Acceso> existingAcceso = accesoService.read(id);
	        if (existingAcceso.isPresent()) {
	            acceso.setId(id);
	            return new ResponseEntity<>(accesoService.update(acceso), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAcceso(@PathVariable("id") Long id) {
        try {
            accesoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
