package com.app.paracasa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.paracasa.models.Tipo;
import com.app.paracasa.repo.ITipoRepo;



@Controller
public class TiposController {
						
	
	@Autowired
	private ITipoRepo tipo_repo;
	
	@GetMapping("/tipos/listar")
	public String listartTipos(Model model) 
	{		
		//Listamos todos los productos
		List<Tipo> tipos = tipo_repo.findAll();		
		//Le pasamos la lista de objetos a la vista
		model.addAttribute("tipos", tipos);
				
		return "/tipos/listar";		
	}
	
	
		@GetMapping("/tipos/registrar")
	    public String solicitaForm(Model model) 
		{	
						        	         
	        return "/tipos/registrar";        
	    }
		
		
		@PostMapping("/tipos/registrar")
		public String enviarForm(@ModelAttribute("tipo") Tipo tipo) 
		{	
		    //System.out.println(producto);
			tipo_repo.save(tipo);

		    return "/tipos/resultado";
		}
		
		
	    @GetMapping("/tipos/actualizar/{id}")
	    public String actualizarProducto(@PathVariable(value = "id") int id, Model model) 
		{		
			//Definimos lista de objetos a pasar a la vista		
			List<Tipo> tipos = tipo_repo.findAll();		
			//Le pasamos la lista de objetos a la vista
	        model.addAttribute("tipos", tipos);		
	        //Creamos objeto producto
	        Tipo tipo = tipo_repo.getById(id);				
			//Le pasamos el objeto a la vista 
	        model.addAttribute("tipo", tipo);
	         
	        return "/tipos/actualizar";        
	    }
		
	        
//		@PostMapping("/productos/actualizar")
//		public String actualizarProd(@ModelAttribute("producto") Producto producto)
	//    
//		{	    	
//			
//			producto_repo.update(
//					producto.getId_producto(),
//					producto.getDescripcion(),
//					producto.getNombre(), 
//					producto.getKcal(), 
//					producto.getTipo().getId_tipo()
//					);
//					
//		    return "/productos/resultado";
//		}
		
		
		@GetMapping("/tipos/borrar/{id}")
	    public String borrarPorId(@PathVariable(value = "id") int id) 
		{
	        tipo_repo.deleteById(id);
	        return "redirect:/";
	        //return "ok";
		}
		

	}






