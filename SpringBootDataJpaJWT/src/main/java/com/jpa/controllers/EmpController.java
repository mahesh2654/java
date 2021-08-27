package com.jpa.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.jpa.entity.User;
import com.jpa.exceptions.EmployeeNotFoundException;
import com.jpa.exceptions.EmptyDataException;
import com.jpa.exceptions.InvalidUserException;
import com.jpa.jwt.JwtTokenUtil;
import com.jpa.service.EmployeeService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@RestController
@RequestMapping("employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpController {

	@Autowired
	EmployeeService service;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	User user = null;
	@GetMapping(value = "{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("eid") int empId,HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
	
		Employee e = service.get(empId);

		if (e == null)
			throw new EmployeeNotFoundException("Request", "Employee with id " + empId + " not found");

		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	
	@GetMapping 
	public List<Employee> getAllEmployees(HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);

		List<Employee> list = service.getAll();
		if (list.size() == 0)
			throw new EmptyDataException("No employees in database");
		return list;

	}

	@PostMapping
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee e,HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		service.add(e);
		return new ResponseEntity<Response>(
				new Response("Employee data successfully saved"),HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updatemployee(@Valid @RequestBody Employee e,HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		if (service.update(e))
			return new ResponseEntity<Response>(
					new Response("Employee data successfully updated"),HttpStatus.OK);
					
		else
			throw new EmployeeNotFoundException("Update", "Employee with Id " + e.getEmpid() + " to update not found");
	}

	@DeleteMapping("{eid}")
	public ResponseEntity<Response> deleteEmployee(@PathVariable("eid") int id,HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);

		if (service.delete(id))
			return  new ResponseEntity<Response>(
					new Response("Employee data with Id: " + id + " successfully deleted"),HttpStatus.OK);
		else
			throw new EmployeeNotFoundException("Delete", "Employee with Id " + id + " to delete not found");
	}



}
