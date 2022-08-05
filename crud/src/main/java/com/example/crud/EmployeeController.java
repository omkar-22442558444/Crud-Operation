package com.example.crud;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository emprep;
	 
	@GetMapping("/getMsg/{name}")
	public ResponseEntity<String> getMessage(@PathVariable String name) {
		LocalTime ct=LocalTime.now();
		if(ct.isAfter(LocalTime.of(0, 0)) && ct.isBefore(LocalTime.of(12,0))) {
			return new ResponseEntity<String>("Good Morning"+name,HttpStatus.OK);
		}
		if(ct.isAfter(LocalTime.of(12, 1)) && ct.isBefore(LocalTime.of(16,0))) {
			return new ResponseEntity<String>("Good Afternoon"+name,HttpStatus.OK);
		}
		if(ct.isAfter(LocalTime.of(16, 1)) && ct.isBefore(LocalTime.of(19,0))) {
			return new ResponseEntity<String>("Good Evening"+name,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Good Night"+name,HttpStatus.OK);
		}
		//ResponseEntity<String> greetings="Welcome"+name;
		//return greetings;
	}
	@PostMapping("/insertEmp")
	public Employee insertEmp(@RequestBody Employee employee) {
		return emprep.save(employee);
	}
	@GetMapping("/getEmp")
	 public List<Employee> getEmp()
	 {
	    //return emprep.findAll();
		return (List<Employee>) CatcheManager.cache.values();
	 }
	
	@GetMapping("/getEmpById/{id}")
	public String  getEmpById(@PathVariable int id)
	{
	Optional<Employee> employee=Optional.ofNullable(CatcheManager.cache.get(id));
		//return Optional.of(emprep.findById(id).get());
		if(employee.isPresent()) {
			return employee.toString();
		}
		else {
			return "Employee is not present";
		}
	}
   

  
    
    @PutMapping("/updateEmp")
    public String updateEmp(@RequestBody Employee employee) {
    	if(employee.getId()>0) {
    		Optional<Employee> emp=emprep.findById(employee.getId());
    		
    		if(emp.isPresent()) {
    			return emprep.save(employee).toString();
    		}
    		else {
    			return "Employee is not present";
    		}
    		}
    	else {
    		return "Employee ID is  invalid";
    	}
    	
    		}

    @DeleteMapping("/deleteEmp")
    public String deleteEmp(@RequestBody Employee employee)
    {
	emprep.delete(employee);
	return "Deleted";
	}
    @DeleteMapping("/deleteEmpById/{id}")
    public String deleteEmpById(@PathVariable int id)
    {
    	
	emprep.deleteById(id);
	return "Deleted";
	}
    @DeleteMapping("/deleteEmpById")
    public String deleteEmpById(@RequestBody Employee employee)
    {
    	
	if(employee.getId()>0) {
		Optional<Employee> emp=emprep.findById(employee.getId());
		
		if(emp.isPresent()) {
			 emprep.delete(employee);
			 return"Deleted";
		}
		else {
			return "Employee is not present";
		}
		}
	else {
		return "Employee ID is  invalid";
	}
	} 

}






























