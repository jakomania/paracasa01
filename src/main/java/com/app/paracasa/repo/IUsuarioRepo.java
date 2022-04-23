package com.app.paracasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.paracasa.models.Usuario;


public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	
	Usuario findByNombre(String usuario);
	

	

}
