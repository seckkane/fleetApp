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
import com.softtoolscar.fleetapp.models.VehicleStatus;
import com.softtoolscar.fleetapp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	
	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/vehiclestatus")
	public String findAll(Model model){	
		List<VehicleStatus> vehicleStatuses = vehicleStatusService.getVehicleStatuses();
		model.addAttribute("vehicleStatuses", vehicleStatuses);
	    return "vehiclestatus";
    }
	
	//Post a new VehicleStatus
	@PostMapping("/vehiclestatus/addnew")
	public String addNew(VehicleStatus vehicleStatus){	
		vehicleStatusService.saveVehicleStatus(vehicleStatus);
		return "redirect:/vehiclestatus";
	}
	
	//Get a VehicleStatus by id sous format json
	@RequestMapping("/vehiclestatus/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id){	
		return vehicleStatusService.getVehicleStatusById(id);
	}
	
	//Deleting a VehicleStatus -- methode qui marchera aussi en get
	@RequestMapping(value="/vehiclestatus/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		vehicleStatusService.deleteVehicleStatusById(id);
		return "redirect:/vehiclestatus";
	}
}
