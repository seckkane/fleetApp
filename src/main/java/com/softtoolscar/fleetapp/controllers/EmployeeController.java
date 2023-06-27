package com.softtoolscar.fleetapp.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.softtoolscar.fleetapp.models.Country;
import com.softtoolscar.fleetapp.models.Employee;
import com.softtoolscar.fleetapp.models.EmployeeType;
import com.softtoolscar.fleetapp.models.JobTitle;
import com.softtoolscar.fleetapp.models.State;
import com.softtoolscar.fleetapp.services.CountryService;
import com.softtoolscar.fleetapp.services.EmployeeService;
import com.softtoolscar.fleetapp.services.EmployeeTypeService;
import com.softtoolscar.fleetapp.services.JobTitleService;
import com.softtoolscar.fleetapp.services.StateService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	@Autowired
	private EmployeeTypeService employeeTypeService;
	@Autowired
	private JobTitleService jobTitleService;
	private String index = "redirect:/employee";
	
	@GetMapping("/employee")
	public String findAll(Model model){	
		List<Employee> employees = employeeService.getEmployees();
		List<State> states = stateService.getStates();
		List<Country> countries = countryService.getCountries();
		List<EmployeeType> employeeTypes = employeeTypeService.getEmployeeTypes();
		List<JobTitle> jobTitles = jobTitleService.getJobTitles();
		
		model.addAttribute("countries", countries);
		model.addAttribute("states", states);
		model.addAttribute("employeeTypes", employeeTypes);
		model.addAttribute("jobTitles", jobTitles);
		model.addAttribute("employees", employees);
	    return "employee";
    }
	
	//Post or update a new Employee
	@SuppressWarnings("finally")
	@RequestMapping(value="/employee/addnew", method = {RequestMethod.POST}, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String addNew(Employee employee, @RequestParam("fich") MultipartFile fich, Model model) throws IllegalStateException, IOException {
		Employee e=employee;
		
			e = employeeService.getEmployeeById(employee.getId()).orElse(e);
			employee.setPhoto(e.getPhoto());
		    employeeService.saveEmployee(employee);
		    if (!fich.isEmpty()) {		         
				 String newFileName = employee.getUsername() + ".jpg";			 
				 // Déplacer le fichier vers le dossier de destination
				String baseDirectory = "C://Maven//Projects//fleetapp//src//main//resources//static//assets//img//photos//";
				fich.transferTo(new File(baseDirectory + newFileName));
				// Mettre à jour le chemin de l'image dans l'objet Employee
				employee.setPhoto(newFileName);
				employeeService.saveEmployee(employee);
		    }
		 return "index";
	}

		
		//Get a Employee by id sous format json
		@RequestMapping("/employee/findById")
		@ResponseBody
		public Optional<Employee> findById(int id){	
			return employeeService.getEmployeeById(id);
		}
		
		//Updating a Employee
		@RequestMapping(value="/employee/update", method = {RequestMethod.POST}, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
		public String update(Employee employee,@RequestParam("fich") MultipartFile fich) throws IOException {
			
			 try {
				employee.setPhoto(employee.getUsername() + "jpg"); 
				employeeService.saveEmployee(employee);
			    if (!fich.isEmpty()) {
			       
					 String newFileName = employee.getUsername() + ".jpg";					 
					 // Déplacer le fichier vers le dossier de destination
					String baseDirectory = "C://Maven//Projects//fleetapp//src//main//resources//static//assets//img//photos//";
					fich.transferTo(new File(baseDirectory + newFileName));
	
					// Mettre à jour le chemin de l'image dans l'objet Employee
					employee.setPhoto(newFileName);
					employeeService.saveEmployee(employee);
			    }
			 } catch (Exception e) {
				 	
			  }
			 
		    return index;
	    }
		
		
		//Deleting a Employee -- methode qui marchera aussi en get
		@RequestMapping(value="/employee/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
		public String delete(@PathVariable("id") int id){	
			employeeService.deleteEmployeeById(id);
			return index;
		}
}
