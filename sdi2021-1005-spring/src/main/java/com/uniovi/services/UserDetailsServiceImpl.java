package com.uniovi.services;

import com.uniovi.entities.User;
import com.uniovi.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		// DONE: La clase userdetails.User de spring security implementa la interfaz
		// userdetails, es la clase que utiliza el sistema de autenticación, no es el
		// mismo user que el que maneja nuestra aplicación.
		User user = usersRepository.findByDni(dni);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		//grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ESTUDIANTE"));
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		// DONE: Spring security llama a las propiedades de identificación: Username y
		// password.
		return new org.springframework.security.core.userdetails.User(user.getDni(), user.getPassword(),
				grantedAuthorities);
	}
}
