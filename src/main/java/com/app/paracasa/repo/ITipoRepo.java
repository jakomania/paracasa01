package com.app.paracasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.paracasa.models.Tipo;

@Repository("ITipoRepo")
public interface ITipoRepo extends JpaRepository<Tipo, Integer>{
	
			

	

}
