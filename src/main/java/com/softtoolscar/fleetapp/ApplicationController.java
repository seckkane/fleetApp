package com.softtoolscar.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ApplicationController {

	@GetMapping("/index") 
	public String home () {
		return "index";
	}
	
	@GetMapping("/register") 
	public String register () {
		return "register";
	}
}
