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
	
	@GetMapping("/admin/tipos/listar")
	public String listartTipos(Model model) 
	{		
		//Listamos todos los productos
		List<Tipo> tipos = tipo_repo.findAll();		
		
		//Le pasamos la lista de objetos a la vista
		model.addAttribute("tipos", tipos);
				
		return "/tipos/listar";		
	}
	
	
		@GetMapping("/admin/tipos/registrar")
	    public String solicitarForm(Model model) 
		{	
			//Instanciamos el objeto
			Tipo tipo = new Tipo();
			
			//Le pasamos el objeto a la vista 
	        model.addAttribute("tipo", tipo);
	        
	        return "/tipos/registrar";        
	    }
		
		
		@PostMapping("/admin/tipos/registrar")
		public String enviarForm(@ModelAttribute("tipo") Tipo tipo) 
		{	
			//Registramos los cambios en la BBDD
			tipo_repo.save(tipo);
			
		    return "redirect:/tipos/listar";
		}
		
						
	    @GetMapping("/admin/tipos/actualizar/{id}")
	    public String actualizarProducto(@PathVariable(value = "id") int id, Model model) 
		{		
					
	        //Hacemos select del objeto que queremos actualizar
	        Tipo tipo = tipo_repo.getById(id);
	    	System.out.println("El ID a actualizar es " + tipo.getId_tipo());
	        
			//Le pasamos el objeto a la vista 
	        model.addAttribute("tipo", tipo);
	         
	        return "/tipos/actualizar";        
	    }
		
	        
		@PostMapping("/admin/tipos/actualizar")
		public String actualizarTipo(@ModelAttribute("tipo") Tipo tipo)
	    
		{	    	
			
			Tipo tipoDb = tipo_repo.getById(tipo.getId_tipo()) ;
			tipoDb.setNombre(tipo.getNombre());
			tipo_repo.save(tipoDb);
																			
			return "redirect:/tipos/listar";
		}
		
		
		@GetMapping("/admin/tipos/confirmar/{id}")
	    public String ConfirmarPorId(@PathVariable(value = "id") int id, Model model) 
		{
			Tipo tipoDb = tipo_repo.getById(id) ;
			model.addAttribute("tipo", tipoDb );
			
//	        tipo_repo.deleteById(id);
	        
	        return "/tipos/confirmar";
	        //return "redirect:/";

		}
		
		@GetMapping("/admin/tipos/borrar/{id}")
	    public String borrarPorId(@PathVariable(value = "id") int id) 
		{
			
	        tipo_repo.deleteById(id);
	        
	        //
	        return "redirect:/tipos/listar";

		}

		

	}






