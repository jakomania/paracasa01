package com.app.paracasa.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Pedido  {
	
	@Id		
	private int id_pedido;
		
	@ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

		
	@ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

	
    private int unidades;

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

//	public int getUsuario() {
//		return id_usuario;
//	}
//
//	public void setIdUsuario(int id_usuario) {
//		this.id_usuario = id_usuario;
//	}
//
//	public int getProducto() {
//		return id_producto;
//	}
//
//	public void setProducto(int id_producto) {
//		this.id_producto = id_producto;
//	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	    
    
				
}



