package com.app.paracasa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.paracasa.models.Pedido;
import com.app.paracasa.models.Usuario;
import com.app.paracasa.repo.IPedidoRepo;
import com.app.paracasa.repo.IUsuarioRepo;


@Controller
public class PedidosController {
	
	@Autowired
	private IPedidoRepo pedido_repo;
	
	@Autowired
	private IUsuarioRepo usuario_repo;
			
	
	@GetMapping("/usuario")
	public String listarPedido(Model model) 
	{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String usuario = auth.getName(); 	    	    	    
	    
	    Usuario us = usuario_repo.findByNombre(usuario);
	    
	    List<Pedido> pedidos = pedido_repo.findPedidoUsuario(us.getId_usuario());
	    
	    model.addAttribute("usuario", usuario);
		
		//Le pasamos la lista de objetos a la vista
		model.addAttribute("pedidos", pedidos);
		
		return "/pedidos/listar";
	}
	
	
	
	
}
