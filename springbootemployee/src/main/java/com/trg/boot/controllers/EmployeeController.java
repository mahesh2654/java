package com.trg.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trg.boot.entity.AppResponse;
import com.trg.boot.entity.Employee;
import com.trg.boot.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping()
	public ResponseEntity<AppResponse> saveEmployee(@RequestBody Employee e) {

		service.saveEmployee(e);

		return new ResponseEntity<AppResponse>(
				new AppResponse("success", "Employee with id " + e.getEmpId() + " successfully saved"), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<AppResponse> updateEmployee(@RequestBody Employee e) {

		service.updateEmployee(e);

		return new ResponseEntity<AppResponse>(
				new AppResponse("success", "Employee with id " + e.getEmpId() + " successfully updated"),
				HttpStatus.OK);
	}

	@DeleteMapping("{eid}")
	public ResponseEntity<AppResponse> deleteEmployee(@PathVariable("eid") int eid) {

		service.deleteEmployee(eid);
		return new ResponseEntity<AppResponse>(
				new AppResponse("success", "Employee with id " + eid + " successfully deleted"), HttpStatus.OK);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	@GetMapping("{eid}")
	public Employee getEmployee(@PathVariable int eid) {

		return service.getEmployee(eid);
	}

}
