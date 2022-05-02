package com.app.paracasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.paracasa.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userDetailsService;
			
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); 
		
	    return bCryptPasswordEncoder;
	}
					
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    	
	} 	
    	
    	
//		BCryptPasswordEncoder encoder = passwordEncoder();
//		          
//		    	auth
//		          .inMemoryAuthentication()
//		          .withUser("user")
//		          .password("123")
//		          .roles("USER")
//		          .and()
//		          .withUser("admin")
//		          .password(encoder.encode("admin"))
//		          .roles("USER", "ADMIN");

          
   
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        	.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
	        .antMatchers("/").permitAll()
	        .antMatchers("/register").permitAll()
	        .antMatchers("/webjars/**").permitAll()
	        .antMatchers(HttpMethod.POST, "/api/tipos").permitAll()
            .anyRequest().authenticated()
		    .and()		    
	    .formLogin()
	        .loginPage("/login")
	        .permitAll()
        .and()
        .logout().logoutSuccessUrl("/").permitAll();
        
	}
        
	    //.httpBasic();
	    //.authenticationEntryPoint(null);
	
//          .authorizeRequests()					
//          .anyRequest()
//          .authenticated()
//          .and()
//          .httpBasic();
//    

}
