package com.softtoolscar.fleetapp.security.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Builder
public class User {
		
    @Id
	private String id;
    private String firstname;
    private String lastname;
	private String username;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER) // A chaque chargement de user ses roles sont charges dans appeler getRoles # Lazy
	List<Role> roles;
	
}
