package com.softtoolscar.fleetapp.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.softtoolscar.fleetapp.security.models.User;
import com.softtoolscar.fleetapp.security.service.AccountService;

@Controller
public class LoginController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/user/addnew")
	public RedirectView register(User user, RedirectAttributes redir) {
		
		accountService.addUser(user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword());
		RedirectView  redirectView = new RedirectView("/login",true);
		redir.addFlashAttribute("msglogin","You successfully registered! You can now login");
	    return redirectView;				
	}
	
}
