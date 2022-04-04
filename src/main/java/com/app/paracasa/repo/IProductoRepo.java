package com.app.paracasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.paracasa.models.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{
	
	
	

}
