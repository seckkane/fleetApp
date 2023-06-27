package com.softtoolscar.fleetapp.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softtoolscar.fleetapp.models.Country;
import com.softtoolscar.fleetapp.models.State;
import com.softtoolscar.fleetapp.services.CountryService;
import com.softtoolscar.fleetapp.services.StateService;

@Controller
public class StateController {
	
	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	
	//Get All Countries
	@GetMapping("/state")
	public String findAll(Model model){	
		
		List<Country> countries = countryService.getCountries();
		List<State> states = stateService.getStates();
		
		model.addAttribute("countries", countries);
		model.addAttribute("states", states);
		
	    return "state";
    }
	
	//Post a new State
	@PostMapping("/state/addnew")
	public String addNew(State state){	
		stateService.saveState(state);
		return "redirect:/state";
	}
	
	//Get a State by id sous format json
	@RequestMapping("/state/findById")
	@ResponseBody
	public Optional<State> findById(int id){	
		return stateService.getStateById(id);
	}
	
	//Deleting a State -- methode qui marchera aussi en get
	@RequestMapping(value="/state/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		stateService.deleteStateById(id);
		return "redirect:/state";
	}
}
