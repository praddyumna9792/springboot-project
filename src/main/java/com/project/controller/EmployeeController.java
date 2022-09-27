package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.NotFoundException;
import com.project.model.Employee;
import com.project.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Long empId) throws NotFoundException {
		return employeeRepository.findById(empId).orElseThrow(() -> new NotFoundException("Employee", "id", empId));
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") Long empId, @RequestBody Employee details) throws NotFoundException {
		Employee employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new NotFoundException("Employee", "id", empId));

		employee.setFirstName(details.getFirstName());
		employee.setLastName(details.getLastName());
		employee.setDob(details.getDob());
		employee.setAddress(details.getAddress());
		employee.setCity(details.getCity());
		employee.setDepartment(details.getDepartment());
		employee.setSkills(details.getSkills());
		
		return employeeRepository.save(employee);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long empId) {
		employeeRepository.deleteById(empId);
		return ResponseEntity.ok().build();
	}
}
