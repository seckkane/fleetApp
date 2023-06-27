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
import com.softtoolscar.fleetapp.models.Client;
import com.softtoolscar.fleetapp.models.State;
import com.softtoolscar.fleetapp.services.CountryService;
import com.softtoolscar.fleetapp.services.ClientService;
import com.softtoolscar.fleetapp.services.StateService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
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
	@GetMapping("/client")
	public String findAll(Model model){	
		
		List<Country> countries = countryService.getCountries();
		List<State> states = stateService.getStates();
		List<Client> clients = clientService.getClients();
		
		model.addAttribute("countries", countries);
		model.addAttribute("states", states);
		model.addAttribute("clients", clients);
		
	    return "client";
    }
	
	//Post a new Client
	@PostMapping("/client/addnew")
	public String addNew(Client client){	
		clientService.saveClient(client);
		return "redirect:/client";
	}
	
	//Get a Client by id sous format json
	@RequestMapping("/client/findById")
	@ResponseBody
	public Optional<Client> findById(int id){	
		return clientService.getClientById(id);
	}
	
	//Deleting a Client -- methode qui marchera aussi en get
	@RequestMapping(value="/client/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		clientService.deleteClientById(id);
		return "redirect:/client";
	}
	
}
