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
import com.example.demo.entity.Cliente;
import com.example.demo.service.CLienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private CLienteService clienteService; 
	
	@GetMapping
	public ResponseEntity<List<Cliente>> readAll(){
		try {
			List<Cliente> clien= clienteService.readAll(); 
			if (clien.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(clien, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente c){
		try {
			Cliente cliente= clienteService.create(c); 
			return new ResponseEntity<>(cliente, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getcliene(@PathVariable("id") Long id){
		Optional<Cliente> cliente= clienteService.read(id); 
		return cliente.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updatecliente(@PathVariable("id") Long id, @Valid @RequestBody Cliente cliente){
		 Optional<Cliente> existingCliente = clienteService.read(id);
	        if (existingCliente.isPresent()) {
	            cliente.setId(id);
	            return new ResponseEntity<>(clienteService.upadate(cliente), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("id") Long id) {
        try {
            clienteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
