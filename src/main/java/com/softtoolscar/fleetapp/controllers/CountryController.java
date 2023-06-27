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
import com.softtoolscar.fleetapp.services.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/country")
	public String findAll(Model model){	
		List<Country> countries = countryService.getCountries();
		model.addAttribute("countries", countries);
	    return "country";
    }
	
	//Post a new Country
	@PostMapping("/country/addnew")
	public String addNew(Country country){	
		countryService.saveCountry(country);
		return "redirect:/country";
	}
	
	//Get a Country by id sous format json
	@RequestMapping("/country/findById")
	@ResponseBody
	public Optional<Country> findById(int id){	
		return countryService.getCountryById(id);
	}
	
	//Deleting a Country -- methode qui marchera aussi en get
	@RequestMapping(value="/country/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		countryService.deleteCountryById(id);
		return "redirect:/country";
	}
}
