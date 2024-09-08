package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Rol;
import com.example.demo.repository.RolRepository;
import com.example.demo.service.RolService;

@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
	private RolRepository repository; 

	@Override
	public Rol crate(Rol c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}

	@Override
	public Rol update(Rol c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Optional<Rol> read(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id); 
	}

	@Override
	public List<Rol> reaAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
