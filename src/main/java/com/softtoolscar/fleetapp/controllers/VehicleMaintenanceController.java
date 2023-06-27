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
import com.softtoolscar.fleetapp.models.Vehicle;
import com.softtoolscar.fleetapp.models.VehicleMaintenance;
import com.softtoolscar.fleetapp.models.Supplier;
import com.softtoolscar.fleetapp.services.VehicleService;
import com.softtoolscar.fleetapp.services.VehicleMaintenanceService;
import com.softtoolscar.fleetapp.services.SupplierService;

@Controller
public class VehicleMaintenanceController {
	
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private SupplierService supplierService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/vehiclemaintenance")
	public String findAll(Model model){	
		
		List<Vehicle> vehicles = vehicleService.getVehicles();
		List<Supplier> suppliers = supplierService.getSuppliers();
		List<VehicleMaintenance> vehicleMaintenances = vehicleMaintenanceService.getVehicleMaintenances();
		
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("vehicleMaintenances", vehicleMaintenances);
		
	    return "vehiclemaintenance";
    }
	
	//Post a new VehicleMaintenance
	@PostMapping("/vehiclemaintenance/addnew")
	public String addNew(VehicleMaintenance vehicleMaintenance){	
		vehicleMaintenanceService.saveVehicleMaintenance(vehicleMaintenance);
		return "redirect:/vehiclemaintenance";
	}
	
	//Get a VehicleMaintenance by id sous format json
	@RequestMapping("/vehiclemaintenance/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id){	
		return vehicleMaintenanceService.getVehicleMaintenanceById(id);
	}
	
	//Deleting a VehicleMaintenance -- methode qui marchera aussi en get
	@RequestMapping(value="/vehiclemaintenance/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		vehicleMaintenanceService.deleteVehicleMaintenanceById(id);
		return "redirect:/vehiclemaintenance";
	}
}
