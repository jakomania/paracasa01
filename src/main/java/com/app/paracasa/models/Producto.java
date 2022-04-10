package com.app.paracasa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Producto  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_producto;
	
	@Column(unique = true, nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String descripcion;		
	
	@Column
	private int kcal;
			
	@ManyToOne
    @JoinColumn(name = "tipo", nullable = false)
    private Tipo tipo;
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
		
}
