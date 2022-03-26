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
		
		//Listamos todos los productos
		List<Producto> productos = repo.findAll();
		//Le pasamos la lista de objetos a la vista
		model.addAttribute("productos", productos);
				
		return "/productos/listar";		
	}
	
	@GetMapping("/productos/registrar")
    public String registrarProducto(Model model) {
		
		//Definimos lista de objetos a pasar a la vista
//		List<String> tipos = Arrays.asList("Entrantes", "Primeros", "Segundos", "Postres");
		List<String> tipos = Arrays.asList("1","2","3","4");
		//Le pasamos la lista de objetos a la vista
        model.addAttribute("tipos", tipos);
		
        //Creamos objeto producto 
		Producto producto = new Producto();
		//Le pasamos el objeto a la vista 
        model.addAttribute("producto", producto);
         
        return "/productos/registrar";        
    }
	
	@PostMapping("/productos/registrar")
	public String submitForm(@ModelAttribute("producto") Producto producto) {
		
	    //System.out.println(producto);
		repo.save(producto);

	    return "/productos/resultado";
	}

}



