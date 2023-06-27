 package com.softtoolscar.fleetapp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.softtoolscar.fleetapp.security.service.impl.UserDetailsServiceImpl;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class Config {

	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Bean //Pour que la methode s'execute au demarrage
	public SecurityFilterChain securityFilterChain ( HttpSecurity httpSecurity) throws Exception {
		httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/",true).permitAll(); //pour utiliser son propre form login
		httpSecurity.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll();
		httpSecurity.authorizeHttpRequests().requestMatchers("/assets/**").permitAll();
		httpSecurity.authorizeHttpRequests().requestMatchers("/register").permitAll();
		httpSecurity.authorizeHttpRequests().requestMatchers("/user/addnew").permitAll();
		//httpSecurity.authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER"); //accessible par le role user
		//httpSecurity.authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN"); //accessible par le role admin
		httpSecurity.authorizeHttpRequests().anyRequest().authenticated(); //Toutes les requetes doivent etre identifiées
		httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized");
		httpSecurity.userDetailsService(userDetailsServiceImpl); //methode a appeler pour essayer de charger l'utilisateur
		return httpSecurity.build();	
	}
	
	
}
