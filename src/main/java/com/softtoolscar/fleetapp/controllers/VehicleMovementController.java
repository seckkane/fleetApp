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
import com.softtoolscar.fleetapp.models.VehicleMovement;
import com.softtoolscar.fleetapp.models.Vehicle;
import com.softtoolscar.fleetapp.services.LocationService;
import com.softtoolscar.fleetapp.services.VehicleMovementService;
import com.softtoolscar.fleetapp.services.VehicleService;

@Controller
public class VehicleMovementController {
	
	@Autowired
	private VehicleMovementService vehicleMovementService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private VehicleService vehicleService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/vehiclemovement")
	public String findAll(Model model){	
		
		List<Location> locations = locationService.getLocations();
		List<Vehicle> vehicles = vehicleService.getVehicles();
		List<VehicleMovement> vehicleMovements = vehicleMovementService.getVehicleMovements();
		
		model.addAttribute("locations", locations);
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("vehicleMovements", vehicleMovements);
		
	    return "vehicleMovement";
    }
	
	//Post a new VehicleMovement
	@PostMapping("/vehiclemovement/addnew")
	public String addNew(VehicleMovement vehicleMovement){	
		vehicleMovementService.saveVehicleMovement(vehicleMovement);
		return "redirect:/vehiclemovement";
	}
	
	//Get a VehicleMovement by id sous format json
	@RequestMapping("/vehiclemovement/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id){	
		return vehicleMovementService.getVehicleMovementById(id);
	}
	
	//Deleting a VehicleMovement -- methode qui marchera aussi en get
	@RequestMapping(value="/vehiclemovement/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		vehicleMovementService.deleteVehicleMovementById(id);
		return "redirect:/vehiclemovement";
	}
}
