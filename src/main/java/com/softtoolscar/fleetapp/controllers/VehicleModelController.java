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
import com.softtoolscar.fleetapp.models.VehicleModel;
import com.softtoolscar.fleetapp.services.VehicleModelService;

@Controller
public class VehicleModelController {
	
	@Autowired
	private VehicleModelService vehicleModelService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/vehiclemodel")
	public String findAll(Model model){	
		List<VehicleModel> vehicleModels = vehicleModelService.getVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);
	    return "vehiclemodel";
    }
	
	//Post a new VehicleModel
	@PostMapping("/vehiclemodel/addnew")
	public String addNew(VehicleModel vehicleModel){	
		vehicleModelService.saveVehicleModel(vehicleModel);
		return "redirect:/vehiclemodel";
	}
	
	//Get a VehicleModel by id sous format json
	@RequestMapping("/vehiclemodel/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id){	
		return vehicleModelService.getVehicleModelById(id);
	}
	
	//Deleting a VehicleModel -- methode qui marchera aussi en get
	@RequestMapping(value="/vehiclemodel/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		vehicleModelService.deleteVehicleModelById(id);
		return "redirect:/vehiclemodel";
	}
}
