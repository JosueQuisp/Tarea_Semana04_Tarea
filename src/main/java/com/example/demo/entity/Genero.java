package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "generos")

public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
	@Column(name = "nombre" , length = 100)
	private String nombre;
	
	
	//generos a peliculas
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "genero")
	@JsonIgnore
	private Set<Pelicula> pelicula; 
	
	

}
