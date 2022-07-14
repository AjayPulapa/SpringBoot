package com.mss.task.crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	// Inserting Data into a table
	@PostMapping("/employee")
	public Map<String, Object> insertEmployee(@RequestBody Employee employee) {
		return employeeService.insertEmployee(employee);
	}
	// updating the data into a table
	@PutMapping("/employee/{id}")
	public Map<String, Object> updateEmployee(@PathVariable int id,@RequestParam String name) {
		return employeeService.updateEmployee(id,name);
	}

	// Deleting the data into the table
	@DeleteMapping("/employee/{id}")
	public Map<String, Object> deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}

	// Getting all the rows in a table
	@GetMapping("/employee/{id}")
	public List<Map<String, Object>> getEmployeeDetails(@PathVariable int id,@RequestParam int age) {
		return employeeService.getEmployeeDetails(id,age);
	}

	// ============================================================================

	
	  @GetMapping("/employee") 
	  public List<HashMap<String, Object>> getEmployeeDetails1(Employee employee) {
	  return employeeService.getEmployeeDetails1(employee); 
	  }
	 
//	@GetMapping("/count")
//	public long count(Employee1 employee)
//	{
//		return employeeService.count(employee);
//	}
}

