package com.softtoolscar.fleetapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.softtoolscar.fleetapp.security.service.AccountService;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class FleetappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetappApplication.class, args);
	} 
	
	@Bean
	PasswordEncoder passwordEncoder () {
	    return new BCryptPasswordEncoder();	
	}
	
	@Bean
	public AuditorAware<String> auditorAware(){
		return new SpringSecurityAuditorAware();
	}
	
	 //@Bean
	 CommandLineRunner clr (AccountService accServ)  {
		 return args -> {
			    //accServ.addRole("ADMIN");
			    //accServ.addRole("USER");
			    
			    accServ.addUser("marieless", "dalaljamm");
			    accServ.addUser("fatoukine", "dalaljamm");
			    
			    //accServ.addRoleToUser("admin", "ADMIN");
			    //accServ.addRoleToUser("admin", "USER");
			    accServ.addRoleToUser("marieless", "USER");
			    accServ.addRoleToUser("fatoukine", "USER");
			    	};
			    }	

}
