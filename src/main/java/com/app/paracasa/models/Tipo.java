package com.app.paracasa.models;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Tipo  {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_tipo;
	
	//@Column(name = "nombre", length = 45)
	private String nombre;
	
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
			
}
