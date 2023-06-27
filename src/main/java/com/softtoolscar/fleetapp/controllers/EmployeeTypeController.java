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
import com.softtoolscar.fleetapp.models.EmployeeType;
import com.softtoolscar.fleetapp.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {
	
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/employeetype")
	public String findAll(Model model){	
		List<EmployeeType> employeeTypes = employeeTypeService.getEmployeeTypes();
		model.addAttribute("employeeTypes", employeeTypes);
	    return "employeetype";
    }
	
	//Post a new EmployeeType
	@PostMapping("/employeetype/addnew")
	public String addNew(EmployeeType employeeType){	
		employeeTypeService.saveEmployeeType(employeeType);
		return "redirect:/employeetype";
	}
	
	//Get a EmployeeType by id sous format json
	@RequestMapping("/employeetype/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id){	
		return employeeTypeService.getEmployeeTypeById(id);
	}
	
	//Deleting a EmployeeType -- methode qui marchera aussi en get
	@RequestMapping(value="/employeetype/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		employeeTypeService.deleteEmployeeTypeById(id);
		return "redirect:/employeetype";
	}
}
