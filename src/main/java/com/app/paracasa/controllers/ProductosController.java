package com.app.paracasa.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.paracasa.models.Producto;
import com.app.paracasa.repo.IProductoRepo;

	
@Controller
public class ProductosController {
	
	@Autowired
	private IProductoRepo repo;

//	@GetMapping("/productos/saludar")
//	public String saludar() {
//		
//		Producto p = new Producto();
//		p.setNombre("Fideos con 3 delicias");
//		p.setDescripcion("Deliciosos fideos chinos");
//		p.setTipo(2);
//		p.setKcal(800);
	
//		repo.save(p);
//		
//		return "index";
//	}
	
	@GetMapping("/productos/listar")
	public String listartProductos(Model model) {
		
		List<Producto> productos = repo.findAll();												
		model.addAttribute("productos", productos);
				
		return "/productos/listar";		
	}
	
	@GetMapping("/productos/registrar")
    public String registrarProducto(Model model) {
		
//		List<String> tipos = Arrays.asList("Entrantes", "Primeros", "Segundos", "Postres");
		List<String> tipos = Arrays.asList("1","2","3","4");
        model.addAttribute("tipos", tipos);
		
		Producto producto = new Producto();
        model.addAttribute("producto", producto);
         
        return "/productos/registrar";        
    }
	
	@PostMapping("/productos/registrar")
	public String submitForm(@ModelAttribute("producto") Producto producto) {
		
	    System.out.println(producto);
		repo.save(producto);

	    return "/productos/resultado";
	}

}



