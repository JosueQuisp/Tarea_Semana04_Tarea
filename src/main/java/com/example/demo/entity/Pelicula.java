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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "peliculas")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
	@Column(name = "nombre", length = 100)
	private String nombre; 
	
	@Column(name = "despripcion", length = 200)
	private String despripcion; 
	
	@Column(name = "director", length = 100)
	private String director;
	
	
	//Muchos a uno peliculas a generos
	@ManyToOne
	@JoinColumn(name = "genero_id", nullable = false)
	private Genero genero; 
	
	// peliculas a renta 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pelicula")
	@JsonIgnore
	private Set<Renta> renta;
	

}
