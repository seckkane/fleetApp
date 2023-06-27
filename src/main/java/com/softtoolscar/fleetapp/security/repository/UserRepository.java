package com.softtoolscar.fleetapp.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtoolscar.fleetapp.security.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
