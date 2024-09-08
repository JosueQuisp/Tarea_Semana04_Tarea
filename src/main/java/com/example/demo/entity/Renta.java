package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "rentas")
public class Renta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro")
	private Date fecha_registro; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_devolucion")
	private Date fecha_devolucion; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_entrega")
	private Date fecha_entrega; 
	
	//renta a peliculas
	
	@ManyToOne
	@JoinColumn(name = "pelicula_id", nullable = false)
	private Pelicula pelicula; 
	
	//renta a cliente
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente; 
	
	// MUCHOS A UNO DE RENTA A USUARIO 
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario; 
	
	

}
