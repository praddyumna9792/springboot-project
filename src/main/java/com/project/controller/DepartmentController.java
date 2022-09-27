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
import com.project.model.Department;
import com.project.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping
	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Long id) throws NotFoundException {
		return departmentRepository.findById(id).orElseThrow(() -> new NotFoundException("Department", "id", id));
	}
	
	@PostMapping
	public Department createDepartment(@RequestBody Department department) {
		return departmentRepository.save(department);
	}

	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department details) throws NotFoundException {
		
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Department", "id", id));

		department.setDepartmentName(details.getDepartmentName());
		department.setDescription(details.getDescription());
		
		return departmentRepository.save(department);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable("id") Long id) {
		departmentRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
