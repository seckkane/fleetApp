package com.softtoolscar.fleetapp.security.service.impl;

import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtoolscar.fleetapp.security.models.Role;
import com.softtoolscar.fleetapp.security.models.User;
import com.softtoolscar.fleetapp.security.repository.RoleRepository;
import com.softtoolscar.fleetapp.security.repository.UserRepository;
import com.softtoolscar.fleetapp.security.service.AccountService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	@Override
	public User addUser(String username, String password) {
		User user = userRepository.findByUsername(username);
		if(user != null) throw new RuntimeException("This user already exists..");
		
		user = User.builder()
					 .id(UUID.randomUUID().toString())
					 .username(username)
					 .password(passwordEncoder.encode(password))
					 .build();
		return userRepository.save(user);
	}
	
	@Override
	public User addUser(String firstname, String lastname, String username, String password) {
		User user = userRepository.findByUsername(username);
		if(user != null) throw new RuntimeException("This user already exists..");
		
		user = User.builder()
					 .id(UUID.randomUUID().toString())
					 .firstname(firstname)
					 .lastname(lastname)
					 .username(username)
					 .password(passwordEncoder.encode(password))
					 .build();
		return userRepository.save(user);
	}
	
	@Override
	public Role addRole(String role) {
		Role r = roleRepository.findById(role).orElse(null);
		if(r != null) throw new RuntimeException("Role allready exists..");
		
		r = Role.builder()
				 .libRole(role)
				 .build();
		return roleRepository.save(r);
	}

	@Override
	public User loadUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void addRoleToUser(String username, String role) {
		User u = userRepository.findByUsername(username);
		Role r = roleRepository.findById(role).get();
		u.getRoles().add(r);
		userRepository.save(u);
	}

	@Override
	public void RemoveRoleFromUser(String username, String role) {
		User u = userRepository.findByUsername(username);
		Role r = roleRepository.findById(role).get();
		u.getRoles().remove(r);
		userRepository.save(u);
	}

}
