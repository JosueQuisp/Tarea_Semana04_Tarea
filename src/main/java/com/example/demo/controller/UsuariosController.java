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
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuarioService usuarioService; 
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> readAll(){
		try {
			List<Usuario> usua= usuarioService.readAll(); 
			if (usua.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(usua, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario c){
		try {
			Usuario usuarios= usuarioService.crate(c); 
			return new ResponseEntity<>(usuarios, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getusuario(@PathVariable("id") Long id){
		Optional<Usuario> usuaa= usuarioService.read(id); 
		return usuaa.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateusuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario){
		 Optional<Usuario> existingusuario = usuarioService.read(id);
	        if (existingusuario.isPresent()) {
	            usuario.setId(id);
	            return new ResponseEntity<>(usuarioService.update(usuario), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteusuario(@PathVariable("id") Long id) {
        try {
            usuarioService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	

}
