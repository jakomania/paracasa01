package com.app.paracasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.paracasa.models.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{
	
	
	

}
