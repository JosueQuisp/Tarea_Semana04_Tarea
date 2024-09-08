package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Cliente;

public interface CLienteService {
	Cliente create(Cliente c);
    Cliente upadate(Cliente c);
    void delete(Long id); 
    Optional< Cliente> read(Long id);
    List<Cliente> readAll(); 
}
