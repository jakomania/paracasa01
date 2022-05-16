package com.app.paracasa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.paracasa.models.Producto;
import com.app.paracasa.repo.IProductoRepo;

@RestController
@RequestMapping(value= "/api/productos")
public class RestProductosController {
		
	@Autowired
	private IProductoRepo repo;
	
	/* Listar */
	@GetMapping
	public List<Producto> listarProductos()
	{
		return repo.findAll();
	}
	
	/* Insertar */
	@PostMapping	
	public void insertarProducto(@RequestBody Producto producto)
	{
		 repo.save(producto);
	}

	/* Actualizar */
	@PutMapping	
	public void actualizarProducto(@RequestBody Producto producto)
	{
		 repo.save(producto);
	}
	
	/* Borrar */ 
	@DeleteMapping(value = "/{id}")
	public void eliminarProducto(@PathVariable("id") Integer id) 
	{
		repo.deleteById(id);	
	}	

}
