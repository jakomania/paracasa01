package com.app.paracasa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.paracasa.models.Usuario;
import com.app.paracasa.repo.IUsuarioRepo;


@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private IUsuarioRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario us = repo.findByNombre(username);
		
		List<GrantedAuthority> roles = new ArrayList<>();
			
		
		if (username.equals("admin")) 
		{
			roles.add(new SimpleGrantedAuthority("ADMIN"));
		}
		else
		{
			roles.add(new SimpleGrantedAuthority("USER"));
		}
		
		UserDetails usDet = new User(us.getNombre(), us.getClave(), roles);
		
		return usDet;
	}

}
