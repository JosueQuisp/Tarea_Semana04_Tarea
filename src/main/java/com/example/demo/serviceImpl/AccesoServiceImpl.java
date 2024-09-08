package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Acceso;
import com.example.demo.repository.AccesoRepository;
import com.example.demo.service.AccesoService;

@Service
public class AccesoServiceImpl implements AccesoService{
	
	@Autowired
	private AccesoRepository accesoRepository;

	@Override
	public Acceso create(Acceso c) {
		// TODO Auto-generated method stub
		return accesoRepository.save(c);
	}

	@Override
	public Acceso update(Acceso c) {
		// TODO Auto-generated method stub
		return accesoRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accesoRepository.deleteById(id);
	}

	@Override
	public Optional<Acceso> read(Long id) {
		// TODO Auto-generated method stub
		return accesoRepository.findById(id);
	}

	@Override
	public List<Acceso> redAll() {
		// TODO Auto-generated method stub
		return accesoRepository.findAll();
	} 
	
	

}
