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
import com.softtoolscar.fleetapp.models.Location;
import com.softtoolscar.fleetapp.models.VehicleHire;
import com.softtoolscar.fleetapp.models.Client;
import com.softtoolscar.fleetapp.models.Vehicle;
import com.softtoolscar.fleetapp.services.ClientService;
import com.softtoolscar.fleetapp.services.LocationService;
import com.softtoolscar.fleetapp.services.VehicleHireService;
import com.softtoolscar.fleetapp.services.VehicleService;


@Controller
public class VehicleHireController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleHireService vehicleHireService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/vehiclehire")
	public String findAll(Model model){	
		
		List<Vehicle> vehicles = vehicleService.getVehicles();
		List<Client> clients = clientService.getClients();
		List<Location> locations = locationService.getLocations();
		List<VehicleHire> vehicleHires = vehicleHireService.getVehicleHires();
		
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("clients", clients);
		model.addAttribute("locations", locations);
		model.addAttribute("vehicleHires", vehicleHires);
		
	    return "vehicleHire";
    }
	
	//Post a new VehicleHire
	@PostMapping("/vehiclehire/addnew")
	public String addNew(VehicleHire vehicleHire){	
		vehicleHireService.saveVehicleHire(vehicleHire);
		return "redirect:/vehiclehire";
	}
	
	//Get a VehicleHire by id sous format json
	@RequestMapping("/vehiclehire/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id){	
		return vehicleHireService.getVehicleHireById(id);
	}
	
	
	//Deleting a VehicleHire -- methode qui marchera aussi en get
	@RequestMapping(value="/vehiclehire/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		vehicleHireService.deleteVehicleHireById(id);
		return "redirect:/vehiclehire";
	}
}
