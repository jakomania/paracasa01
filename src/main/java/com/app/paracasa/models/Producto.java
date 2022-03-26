package com.app.paracasa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Producto  {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_producto;
	
	@Column(name = "nombre", length = 45)
	private String nombre;
	
	@Column(name = "descripcion", length = 45)
	private String descripcion;		
	
	private int kcal;
	
	private int tipo;
	
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
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
		
}
