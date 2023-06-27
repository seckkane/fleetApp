package com.softtoolscar.fleetapp.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.softtoolscar.fleetapp.security.models.User;
import com.softtoolscar.fleetapp.security.service.AccountService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private AccountService accServ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = accServ.loadUserByUsername(username);
		if(u == null) throw new UsernameNotFoundException(String.format("User : %s not found",username));
		String[] roles = u.getRoles().stream().map(user->user.getLibRole()).toArray(String[]::new);
		
		//On retourne a la methode httpSecurity.user details service l'utilisateur avec ces details
		//il est de type user details
		return org.springframework.security.core.userdetails.User.withUsername(u.getUsername()) 
				   .password(u.getPassword())
				   .roles(roles)
				   .build();
	}
}
