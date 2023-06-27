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
import com.softtoolscar.fleetapp.models.Supplier;
import com.softtoolscar.fleetapp.models.State;
import com.softtoolscar.fleetapp.services.CountryService;
import com.softtoolscar.fleetapp.services.SupplierService;
import com.softtoolscar.fleetapp.services.StateService;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
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
	@GetMapping("/supplier")
	public String findAll(Model model){	
		
		List<Country> countries = countryService.getCountries();
		List<State> states = stateService.getStates();
		List<Supplier> suppliers = supplierService.getSuppliers();
		
		model.addAttribute("countries", countries);
		model.addAttribute("states", states);
		model.addAttribute("suppliers", suppliers);
		
	    return "supplier";
    }
	
	//Post a new Supplier
	@PostMapping("/supplier/addnew")
	public String addNew(Supplier supplier){	
		supplierService.saveSupplier(supplier);
		return "redirect:/supplier";
	}
	
	//Get a Supplier by id sous format json
	@RequestMapping("/supplier/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id){	
		return supplierService.getSupplierById(id);
	}
	
	//Deleting a Supplier -- methode qui marchera aussi en get
	@RequestMapping(value="/supplier/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		supplierService.deleteSupplierById(id);
		return "redirect:/supplier";
	}
}
