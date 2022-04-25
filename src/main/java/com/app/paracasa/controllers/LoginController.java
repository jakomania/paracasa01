package com.app.paracasa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.paracasa.models.Usuario;
import com.app.paracasa.repo.IUsuarioRepo;


@Controller
public class LoginController {
	
	@Autowired
	private IUsuarioRepo repo;
		
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/login")
	public String solicitarForm() 
	{				
		return "/login";	
	}
	
	
	@GetMapping("/register")
	public String solicitarForm(Model model) {
	    model.addAttribute("usuario", new Usuario());
	     
	    return "/register";
	}
	
	
	@PostMapping("/register")
	public String enviarForm(@ModelAttribute("usuario") Usuario usuario) 
	{	
		
		//Ciframos el input de usuario para la pass
		usuario.setClave(encoder.encode(usuario.getClave()));
		
		//Registramos los cambios en la BBDD
		repo.save(usuario);
		
	    return "/okregistro";
	}
	
	@GetMapping("/admin")
	public String adminPanel() 
	{		
		return "/admin";
		
	}
	
	
//	@GetMapping("/testauth")
//	public String testAuth() 
//	{
//		Usuario us = new Usuario();
//		us.setNombre("jacobr");		
//		us.setCorreo("jrc@protonmail.com");
//		us.setClave(encoder.encode("321"));
//		repo.save(us);
//		
//		//System.out.println("INSERTADO USUARIO:" + retorno.getUsuario());
//		
//		return "/ok";		
//	}
	
	
	

}
