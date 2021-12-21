package com.jpa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Employee;
import com.jpa.entity.Response;
import com.jpa.exceptions.EmployeeNotFoundException;
import com.jpa.exceptions.EmptyDataException;

import com.jpa.service.EmployeeService;

@RestController
@RequestMapping("employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpController {

	@Autowired
	EmployeeService service;

	@GetMapping(value = "{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("eid") int empId) {
		Employee e = service.get(empId);

		if (e == null)
			throw new EmployeeNotFoundException("Request", "Employee with id " + empId + " not found");

		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	
	@GetMapping 
	public List<Employee> getAllEmployees() {

		List<Employee> list = service.getAll();
		if (list.size() == 0)
			throw new EmptyDataException("No employees in database");
		return list;

	}

	@PostMapping
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee e) {
		service.add(e);
		return new ResponseEntity<String>("Employee data successfully saved",HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> updatemployee(@Valid @RequestBody Employee e) {
		if (service.update(e))
			return ResponseEntity.ok("Employee data successfully updated");
		else
			throw new EmployeeNotFoundException("Update", "Employee with Id " + e.getEmpid() + " to update not found");
	}
	

	@DeleteMapping("{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("eid") int id) {

		if (service.delete(id))
			return  new ResponseEntity<String>("Employee data with Id: " + id + " successfully deleted",HttpStatus.OK);
		else
			throw new EmployeeNotFoundException("Delete", "Employee with Id " + id + " to delete not found");
	}

}
