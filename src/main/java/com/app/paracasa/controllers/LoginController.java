package com.app.paracasa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
//	@PostMapping("/login")
//	public String enviarForm(@ModelAttribute("") Tipo tipo) 
//	{	
//		//Registramos los cambios en la BBDD
//		repo.save(tipo);
//		
//	    return "redirect:/tipos/listar";
//	}
	
	
	@GetMapping("/testauth")
	public String testAuth() 
	{
		Usuario us = new Usuario();
		us.setNombre("Mark Passio");
		us.setUsuario("markp");
		us.setCorreo("markp@protonmail.com");
		us.setClave(encoder.encode("123"));
		Usuario retorno = repo.save(us);
		
		System.out.println("INSERTADO USUARIO:" + retorno.getUsuario());
		
		return "/ok";
		
	}
	

}
