package com.softtoolscar.fleetapp.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtoolscar.fleetapp.security.models.Role;

public interface RoleRepository extends JpaRepository<Role,String> {

}
