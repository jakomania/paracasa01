package com.app.paracasa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.paracasa.models.Usuario;
import com.app.paracasa.repo.IUsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
class ParacasaApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private IUsuarioRepo repo;
	
	@Test
	public void CrearUsuarioTest() 
	{
		Usuario us = new Usuario();
		us.setUsuario("pedro001");
		us.setNombre("Pedro Bustamante");
		us.setCorreo("pedrobus01@yahoo.es");
		us.setClave("pedrobus01@yahoo.es");
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}
	

}
