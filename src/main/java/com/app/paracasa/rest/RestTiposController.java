package com.app.paracasa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.paracasa.models.Tipo;
import com.app.paracasa.repo.ITipoRepo;

@RestController
@RequestMapping(value= "/api/tipos")
public class RestTiposController {
		
	@Autowired
	private ITipoRepo repo;
	
	@GetMapping
	public List<Tipo> listarTipos()
	{
		return repo.findAll();
	}
	
	@PostMapping	
	public void insertarTipo(@RequestBody Tipo tipo)
	{
		 repo.save(tipo);
	}

}
