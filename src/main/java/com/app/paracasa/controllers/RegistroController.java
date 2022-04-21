package com.app.paracasa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.paracasa.models.Usuario;
import com.app.paracasa.repo.IUsuarioRepo;


@Controller
public class RegistroController {
	
	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
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
