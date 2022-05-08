package com.app.paracasa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.paracasa.models.Pedido;
import com.app.paracasa.models.Tipo;
import com.app.paracasa.models.Usuario;
import com.app.paracasa.repo.IPedidoRepo;
import com.app.paracasa.repo.IUsuarioRepo;

@RestController
@RequestMapping(value= "/api/pedidos")
public class RestPedidosController {
	
	@Autowired
	private IPedidoRepo pedido_repo;
	
	@Autowired
	private IUsuarioRepo usuario_repo;
	
	@GetMapping
	public List<Pedido> listarTipos()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String usuario = auth.getName(); 	    	    	    
	    
	    Usuario us = usuario_repo.findByNombre(usuario);
	    
	    List<Pedido> pedidos = pedido_repo.findPedidoUsuario(us.getId_usuario());
		return pedidos;
	}
	
	
    
    
	
	

}
