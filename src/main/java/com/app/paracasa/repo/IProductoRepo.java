package com.app.paracasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.paracasa.models.Producto;

@Repository("IProductoRepo")
public interface IProductoRepo extends JpaRepository<Producto, Integer>{
	
	

}
