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
import com.softtoolscar.fleetapp.models.VehicleMake;
import com.softtoolscar.fleetapp.services.VehicleMakeService;

@Controller
public class VehicleMakeController {
	
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/vehiclemake")
	public String findAll(Model model){	
		List<VehicleMake> vehicleMakes = vehicleMakeService.getVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakes);
	    return "vehiclemake";
    }
	
	//Post a new VehicleMake
	@PostMapping("/vehiclemake/addnew")
	public String addNew(VehicleMake vehicleMake){	
		vehicleMakeService.saveVehicleMake(vehicleMake);
		return "redirect:/vehiclemake";
	}
	
	//Get a VehicleMake by id sous format json
	@RequestMapping("/vehiclemake/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(int id){	
		return vehicleMakeService.getVehicleMakeById(id);
	}
	
	//Deleting a VehicleMake -- methode qui marchera aussi en get
	@RequestMapping(value="/vehiclemake/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		vehicleMakeService.deleteVehicleMakeById(id);
		return "redirect:/vehiclemake";
	}
	
}
