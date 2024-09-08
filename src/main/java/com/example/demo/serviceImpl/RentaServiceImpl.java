package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Renta;
import com.example.demo.repository.RentaRepositoy;
import com.example.demo.service.RentaService;

@Service
public class RentaServiceImpl implements RentaService {
	
	@Autowired
	private RentaRepositoy rentaRepositoy;

	@Override
	public Renta create(Renta c) {
		// TODO Auto-generated method stub
		return rentaRepositoy.save(c);
	}

	@Override
	public Renta update(Renta c) {
		// TODO Auto-generated method stub
		return rentaRepositoy.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		rentaRepositoy.deleteById(id);
	}

	@Override
	public Optional<Renta> read(Long id) {
		// TODO Auto-generated method stub
		return rentaRepositoy.findById(id);
	}

	@Override
	public List<Renta> readAll() {
		// TODO Auto-generated method stub
		return rentaRepositoy.findAll();
	} 
	

}
