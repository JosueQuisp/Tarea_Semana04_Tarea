package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "empleados")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
	@Column(name = "nombres", length = 100)
	private String nombres;
	
	@Column(name = "apellidos", length = 100)
	private String apellidos;
	
	@Column(name = "documento", length = 50)
	private String documento;
	
	@Column(name = "telefono" , length = 9)
	private String telefono;
	
	@Column(name = "correo", length = 100)
	private String correo;
	
	@Column(name = "estado")
	private char estado; 
	
	
	// UNO A UNO DE EMPLEADO A USUARIO 
	
	@OneToOne(mappedBy = "empleado")
	private Usuario usuario; 

}
