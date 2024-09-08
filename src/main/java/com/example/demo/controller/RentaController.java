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
import com.example.demo.entity.Renta;
import com.example.demo.service.RentaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rentas")
public class RentaController {
	
	@Autowired
	private RentaService rentaService; 
	
	@GetMapping
	public ResponseEntity<List<Renta>> readAll(){
		try {
			List<Renta> rentad= rentaService.readAll(); 
			if (rentad.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(rentad, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Renta> create(@Valid @RequestBody Renta c){
		try {
			Renta ren= rentaService.create(c); 
			return new ResponseEntity<>(ren, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Renta> getrenta(@PathVariable("id") Long id){
		Optional<Renta> rens= rentaService.read(id); 
		return rens.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Renta> updaterenta(@PathVariable("id") Long id, @Valid @RequestBody Renta renta){
		 Optional<Renta> existingrenta = rentaService.read(id);
	        if (existingrenta.isPresent()) {
	            renta.setId(id);
	            return new ResponseEntity<>(rentaService.update(renta), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRenta(@PathVariable("id") Long id) {
        try {
            rentaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
