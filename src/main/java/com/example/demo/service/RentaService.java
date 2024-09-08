package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Renta;

public interface RentaService {
	
	Renta create(Renta c);
    Renta update(Renta c); 
    void delete(Long id);
    Optional<Renta> read(Long id);
    List<Renta> readAll(); 



}
