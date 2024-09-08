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
import com.example.demo.entity.Rol;
import com.example.demo.service.RolService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/roles")

public class RolController {
	
	@Autowired
	private RolService  rolService; 
	
	@GetMapping
	public ResponseEntity<List<Rol>> readAll(){
		try {
			List<Rol> rols= rolService.reaAll(); 
			if (rols.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(rols, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Rol> create(@Valid @RequestBody Rol c){
		try {
			Rol rols= rolService.crate(c); 
			return new ResponseEntity<>(rols, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rol> getrol(@PathVariable("id") Long id){
		Optional<Rol> rols= rolService.read(id); 
		return rols.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Rol> updaterol(@PathVariable("id") Long id, @Valid @RequestBody Rol rol){
		 Optional<Rol> existingrol = rolService.read(id);
	        if (existingrol.isPresent()) {
	            rol.setId(id);
	            return new ResponseEntity<>(rolService.update(rol), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleterol(@PathVariable("id") Long id) {
        try {
            rolService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	
	
	
}
