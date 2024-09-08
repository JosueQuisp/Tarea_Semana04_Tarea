package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Genero;
import com.example.demo.repository.GeneroRepository;
import com.example.demo.service.GeneroService;

@Service

public class GeneroServiceImpl  implements GeneroService{
	 @Autowired
	 private GeneroRepository generoRepository;

	@Override
	public Genero create(Genero c) {
		// TODO Auto-generated method stub
		return generoRepository.save(c);
	}

	@Override
	public Genero upadate(Genero c) {
		// TODO Auto-generated method stub
		return generoRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		generoRepository.deleteById(id);
	}

	@Override
	public Optional<Genero> read(Long id) {
		// TODO Auto-generated method stub
		return generoRepository.findById(id);
	}

	@Override
	public List<Genero> readAll() {
		// TODO Auto-generated method stub
		return generoRepository.findAll();
	} 
	 
	 

}
