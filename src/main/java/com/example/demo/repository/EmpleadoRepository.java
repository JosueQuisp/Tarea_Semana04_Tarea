package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
