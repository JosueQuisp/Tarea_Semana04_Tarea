package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "accesos")

public class Acceso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
	@Column(name = "titulo", length = 50)
	private String titulo;
	
	@Column(name = "icono", length = 50)
	private String icono;
	
	@Column(name = "link", length = 100)
	private String link;
	
	@Column(name = "estado")
	private char estado; 
	
	
	// MUCHOS A MUCHOS DE ACCESO A ROL 

	@ManyToMany
	@JsonIgnore
	@JoinTable(
			name = "acceso_rol", 
			joinColumns = @JoinColumn(name= "acceso_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
			)
	
	private Set<Rol> roles= new HashSet<>(); 
	

}
