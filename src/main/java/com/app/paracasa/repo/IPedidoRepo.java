package com.app.paracasa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.paracasa.models.Pedido;


@Repository("IPedidoRepo")
public interface  IPedidoRepo extends JpaRepository <Pedido, Integer>{
	
	@Query("SELECT p FROM Pedido p WHERE p.usuario.id_usuario = :id")
	List<Pedido> findPedidoUsuario(@Param("id") int id);
	

}
