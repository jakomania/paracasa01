package com.app.paracasa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

	
@Controller
public class ProductosController {

	@GetMapping("/saludar")
	public String getProducts() {
		return "index";
	}

}



