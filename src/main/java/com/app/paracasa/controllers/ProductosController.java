package com.app.paracasa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.paracasa.models.Producto;
import com.app.paracasa.models.Tipo;
import com.app.paracasa.repo.IProductoRepo;
import com.app.paracasa.repo.ITipoRepo;

	
@Controller
public class ProductosController {
	
	@Autowired
	private IProductoRepo producto_repo;
	
	@Autowired
	private ITipoRepo tipo_repo;
	
	@GetMapping("/productos/listar")
	public String listartProductos(Model model) 
	{		
		//Listamos todos los productos
		List<Producto> productos = producto_repo.findAll();
		//Le pasamos la lista de objetos a la vista
		model.addAttribute("productos", productos);
				
		return "/productos/listar";		
	}
	
	
	@GetMapping("/productos/registrar")
    public String registrarProducto(Model model) 
	{	
		//Definimos lista de objetos a pasar a la vista		
		List<Tipo> tipos = tipo_repo.findAll();		
		//Le pasamos la lista de objetos a la vista
        model.addAttribute("tipos", tipos);		
        //Creamos objeto producto 
		Producto producto = new Producto();
		//Le pasamos el objeto a la vista 
        model.addAttribute("producto", producto);
         
        return "/productos/registrar";        
    }
	
	
	@PostMapping("/productos/registrar")
	public String submitForm(@ModelAttribute("producto") Producto producto) 
	{	
	    //System.out.println(producto);
		producto_repo.save(producto);

	    return "/productos/resultado";
	}
	
	
//	@GetMapping("/productos/actualizar")
    @GetMapping("/productos/actualizar/{id}")
    public String actualizarProducto(@PathVariable(value = "id") int id, Model model) 
	{		
		//Definimos lista de objetos a pasar a la vista		
		List<Tipo> tipos = tipo_repo.findAll();		
		//Le pasamos la lista de objetos a la vista
        model.addAttribute("tipos", tipos);		
        //Creamos objeto producto
        Producto producto = producto_repo.getById(id);				
		//Le pasamos el objeto a la vista 
        model.addAttribute("producto", producto);
         
        return "/productos/actualizar";        
    }
	
	
	@PostMapping("/productos/actualizar")
	public String actualizarForm(@ModelAttribute("producto") Producto producto) 
	{	
		Producto producto_act = producto_repo.getById(producto.getId_producto());
		producto_act.setId_producto(producto.getId_producto());
		producto_act.setNombre(producto.getNombre());
		producto_act.setDescripcion(producto.getDescripcion());
		producto_act.setTipo(producto.getTipo());
		producto_act.setKcal(producto.getKcal());
		producto_repo.save(producto_act);
				
	    return "/productos/resultado";
	}
	
	
	@GetMapping("/productos/borrar/{id}")
    public String borrarPorId(@PathVariable(value = "id") int id) 
	{
        producto_repo.deleteById(id);
        return "redirect:/";
        //return "ok";
	}
	


}



