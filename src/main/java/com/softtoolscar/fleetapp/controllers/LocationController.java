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
import com.softtoolscar.fleetapp.models.Location;
import com.softtoolscar.fleetapp.models.State;
import com.softtoolscar.fleetapp.services.CountryService;
import com.softtoolscar.fleetapp.services.LocationService;
import com.softtoolscar.fleetapp.services.StateService;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/location")
	public String findAll(Model model){	
		
		List<Country> countries = countryService.getCountries();
		List<State> states = stateService.getStates();
		List<Location> locations = locationService.getLocations();
		
		model.addAttribute("countries", countries);
		model.addAttribute("states", states);
		model.addAttribute("locations", locations);
		
	    return "location";
    }
	
	//Post a new Location
	@PostMapping("/location/addnew")
	public String addNew(Location location){	
		locationService.saveLocation(location);
		return "redirect:/location";
	}
	
	//Get a Location by id sous format json
	@RequestMapping("/location/findById")
	@ResponseBody
	public Optional<Location> findById(int id){	
		return locationService.getLocationById(id);
	}
	
	//Deleting a Location -- methode qui marchera aussi en get
	@RequestMapping(value="/location/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		locationService.deleteLocationById(id);
		return "redirect:/location";
	}
	
}
