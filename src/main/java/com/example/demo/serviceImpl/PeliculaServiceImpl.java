package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pelicula;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.service.PeliculaService;

@Service

public class PeliculaServiceImpl implements PeliculaService{

	@Autowired
	private PeliculaRepository peliculaRepository; 
	@Override
	public Pelicula create(Pelicula c) {
		// TODO Auto-generated method stub
		return peliculaRepository.save(c);
	}

	@Override
	public Pelicula update(Pelicula c) {
		// TODO Auto-generated method stub
		return peliculaRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		peliculaRepository.deleteById(id);
	}

	@Override
	public Optional<Pelicula> read(Long id) {
		// TODO Auto-generated method stub
		return peliculaRepository.findById(id);
	}

	@Override
	public List<Pelicula> readAll() {
		// TODO Auto-generated method stub
		return peliculaRepository.findAll();
	}
	


}
