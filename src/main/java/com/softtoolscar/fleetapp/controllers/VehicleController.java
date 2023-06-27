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

import com.softtoolscar.fleetapp.models.Employee;
import com.softtoolscar.fleetapp.models.Location;
import com.softtoolscar.fleetapp.models.Vehicle;
import com.softtoolscar.fleetapp.models.VehicleMake;
import com.softtoolscar.fleetapp.models.VehicleModel;
import com.softtoolscar.fleetapp.models.VehicleStatus;
import com.softtoolscar.fleetapp.models.VehicleType;
import com.softtoolscar.fleetapp.services.EmployeeService;
import com.softtoolscar.fleetapp.services.LocationService;
import com.softtoolscar.fleetapp.services.VehicleMakeService;
import com.softtoolscar.fleetapp.services.VehicleModelService;
import com.softtoolscar.fleetapp.services.VehicleService;
import com.softtoolscar.fleetapp.services.VehicleStatusService;
import com.softtoolscar.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private VehicleMakeService vehicleMakeService;
	@Autowired
	private VehicleStatusService vehicleStatusService;
	@Autowired
	private VehicleTypeService vehicleTypeService;
	@Autowired
	private VehicleModelService vehicleModelService;
	
	
	//Get All Countries
	@GetMapping("/vehicle")
	public String findAll(Model model){	
		
		List<Vehicle> vehicles = vehicleService.getVehicles();
		List<Location> locations = locationService.getLocations();
		List<Employee> employees = employeeService.getEmployees();
		List<VehicleMake> vehicleMakes = vehicleMakeService.getVehicleMakes();
		List<VehicleStatus> vehicleStatuses = vehicleStatusService.getVehicleStatuses();
		List<VehicleType> vehicleTypes = vehicleTypeService.getVehicleTypes();
		List<VehicleModel> vehicleModels = vehicleModelService.getVehicleModels();
		
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("locations", locations);
		model.addAttribute("employees", employees);
		model.addAttribute("vehicleMakes", vehicleMakes);
		model.addAttribute("vehicleStatuses", vehicleStatuses);
		model.addAttribute("vehicleTypes", vehicleTypes);
		model.addAttribute("vehicleModels", vehicleModels);
		
	    return "vehicle";
    }
	
	//Post a new Vehicle
	@PostMapping("/vehicle/addnew")
	public String addNew(Vehicle vehicle){	
		vehicleService.saveVehicle(vehicle);
		return "redirect:/vehicle";
	}
	
	//Get a Vehicle by id sous format json
	@RequestMapping("/vehicle/findById")
	@ResponseBody
	public Optional<Vehicle> findById(int id){	
		return vehicleService.getVehicleById(id);
	}
	
	//Deleting a Vehicle -- methode qui marchera aussi en get
	@RequestMapping(value="/vehicle/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		vehicleService.deleteVehicleById(id);
		return "redirect:/vehicle";
	}
}
