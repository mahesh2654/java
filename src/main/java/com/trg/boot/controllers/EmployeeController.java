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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trg.boot.entity.Employee;

import com.trg.boot.entity.AppResponse;
import com.trg.boot.exceptions.DataNotFoundException;
import com.trg.boot.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		List<Employee> list = service.getAllEmployees();
		return list;
	}

	// @RequestMapping(value = "{empid}", method = RequestMethod.GET)
	@GetMapping("{empid}")
	public ResponseEntity<?> getOneEmployee(@PathVariable("empid") int eid) {
		Employee x = service.getEmployee(eid);

		if (x != null)
			return new ResponseEntity<Employee>(x, HttpStatus.OK);
		else
			throw new DataNotFoundException("NOTFND", "Employee with Id " + eid + " not found");
	}

	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping()
	public ResponseEntity<AppResponse> saveEmployee(@RequestBody Employee e) { // @RequestBody helps in converting JSON
																			// data in the body into
		service.createEmployee(e);
		return new ResponseEntity<AppResponse>(new AppResponse("success", "Employee with id " + e.getEmpId() + " successfully saved"), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<AppResponse> updateEmployee(@RequestBody Employee e) { // @RequestBody helps in converting JSON
																				// data in the body into Employee object
		service.updateEmployee(e);
		return new ResponseEntity<AppResponse>(new AppResponse("success", "Employee with id " + e.getEmpId() + " successfully updated"), HttpStatus.OK);
	}

	// @RequestMapping(value = "{empid}", method = RequestMethod.DELETE)
	@DeleteMapping("{empid}")
	public ResponseEntity<AppResponse> deleteEmployee(@PathVariable("empid") int eid) {

		service.deleteEmployee(eid);
		return new ResponseEntity<AppResponse>(new AppResponse("success", "Employee with id " + eid + " successfully deleted"), HttpStatus.OK);

	}
}
