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
import com.jpa.entity.User;
import com.jpa.exceptions.EmployeeNotFoundException;
import com.jpa.exceptions.EmptyDataException;
import com.jpa.exceptions.InvalidTokenException;
import com.jpa.exceptions.NotAuthorizedException;
import com.jpa.jwt.JwtUtil;
import com.jpa.service.EmployeeService;

@RestController
@RequestMapping("employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpController {

	@Autowired
	EmployeeService service;

	@Autowired
	private JwtUtil jwtTokenUtil;

	User user = null;

	@GetMapping(value = "{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("eid") int empId, HttpServletRequest request) {
		validateToken(request);

		Employee e = service.get(empId);

		if (e == null)
			throw new EmployeeNotFoundException("Request", "Employee with id " + empId + " not found");

		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	@GetMapping
	public List<Employee> getAllEmployees(HttpServletRequest request) {
		validateToken(request);

		List<Employee> list = service.getAll();
		if (list.size() == 0)
			throw new EmptyDataException("No employees in database");
		return list;
	}

	@PostMapping
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee e, HttpServletRequest request) {
		validateToken(request);

		String role = user.getRole();
		if (!(role.equals("admin")))
			throw new NotAuthorizedException("Save Employee data can be done only by admin");
		
		service.add(e);
		return new ResponseEntity<String>("Employee data successfully saved", HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updatemployee(@Valid @RequestBody Employee e, HttpServletRequest request) {
		validateToken(request);
		
		String role = user.getRole();
		if (!(role.equals("admin")))
			throw new NotAuthorizedException("Update Employee data can be done only by admin");
		
		if (service.update(e))
			return new ResponseEntity<String>("Employee data successfully updated", HttpStatus.OK);

		else
			throw new EmployeeNotFoundException("Update", "Employee with Id " + e.getEmpid() + " to update not found");
	}

	@DeleteMapping("{eid}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("eid") int id, HttpServletRequest request) {
		validateToken(request);
		
		String role = user.getRole();
		if (!(role.equals("admin")))
			throw new NotAuthorizedException("Delete Employee data can be done only by admin");

		if (service.delete(id))
			return new ResponseEntity<String>("Employee data with Id: " + id + " successfully deleted", HttpStatus.OK);
		else
			throw new EmployeeNotFoundException("Delete", "Employee with Id " + id + " to delete not found");
	}

	private void validateToken(HttpServletRequest request) {
		final String tokenHeader = request.getHeader("Authorization");

		String token = null;

		if (tokenHeader == null)
			throw new InvalidTokenException("User Not Logged In or token not included");

		// JWT Token is in the form "Bearer token". Remove Bearer word
		if (!tokenHeader.startsWith("Bearer "))
			throw new InvalidTokenException("Invalid Token");

		token = tokenHeader.substring(7);

		user = jwtTokenUtil.validateTokenAndGetUserDetails(token);
	}

}
