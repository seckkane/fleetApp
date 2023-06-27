package com.softtoolscar.fleetapp.security.service;

import com.softtoolscar.fleetapp.security.models.Role;
import com.softtoolscar.fleetapp.security.models.User;

public interface AccountService {

	User addUser (String username, String password) ;
	User addUser (String firstname, String lastname, String username, String password) ;
	Role addRole (String role);
	User loadUserByUsername(String username);
	void addRoleToUser (String username, String role);
	void RemoveRoleFromUser (String username, String role);
}
