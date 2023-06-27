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
import com.softtoolscar.fleetapp.models.VehicleType;
import com.softtoolscar.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/vehicletype")
	public String findAll(Model model){	
		List<VehicleType> vehicleTypes = vehicleTypeService.getVehicleTypes();
		model.addAttribute("vehicleTypes", vehicleTypes);	
	    return "vehicletype";
    }
	
	//Post a new VehicleType
	@PostMapping("/vehicletype/addnew")
	public String addNew(VehicleType vehicleType){	
		vehicleTypeService.saveVehicleType(vehicleType);
		return "redirect:/vehicletype";
	}
	
	//Get a VehicleType by id sous format json
	@RequestMapping("/vehicletype/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id){	
		return vehicleTypeService.getVehicleTypeById(id);
	}
	
	//Deleting a VehicleType -- methode qui marchera aussi en get
	@RequestMapping(value="/vehicletype/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		vehicleTypeService.deleteVehicleTypeById(id);
		return "redirect:/vehicletype";
	}
}
