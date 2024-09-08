package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService { 
	@Autowired
	private UsuarioRepository repositorys;

	@Override
	public Usuario crate(Usuario c) {
		// TODO Auto-generated method stub
		return repositorys.save(c);
	}

	@Override
	public Usuario update(Usuario c) {
		// TODO Auto-generated method stub
		return repositorys.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repositorys.deleteById(id);
	}

	@Override
	public Optional<Usuario> read(Long id) {
		// TODO Auto-generated method stub
		return repositorys.findById(id);
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return repositorys.findAll();
	}

}
