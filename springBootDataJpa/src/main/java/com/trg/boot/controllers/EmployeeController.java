package com.trg.boot.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

import com.trg.boot.entity.AppResponse;
import com.trg.boot.entity.Employee;
import com.trg.boot.repo.EmployeeRepository;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

	@Autowired
	EmployeeRepository repo;

	@PostMapping
	public ResponseEntity<AppResponse> saveEmployee(@RequestBody Employee e) {
		if (repo.existsById(e.getEmpid())) {
			return new ResponseEntity<AppResponse>(
					new AppResponse("SAVEFAIL", "Employee with id " + e.getEmpid() + " already exists"),
					HttpStatus.BAD_REQUEST);
		} else {
			repo.save(e);
			return new ResponseEntity<AppResponse>(
					new AppResponse("SUCCESS", "Employee data with id " + e.getEmpid() + " successfully created"),
					HttpStatus.CREATED);
		}
	}

	@PutMapping
	public ResponseEntity<?> modifyEmployee(@RequestBody Employee e) {
		if (repo.existsById(e.getEmpid())) {
			repo.save(e);
			return new ResponseEntity<AppResponse>(
					new AppResponse("SUCCESS","Employee with id " + e.getEmpid() + " successfully updated"),HttpStatus.OK);
		} else {
			return new ResponseEntity<AppResponse>(new AppResponse(	"UPDFAIL", "Employee data with id " + e.getEmpid() + " not found"),HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("{eid}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("eid") int empid) {

		if (repo.existsById(empid)) {
			repo.deleteById(empid);
			return new ResponseEntity<AppResponse>(new AppResponse("SUCCESS", "Employee with Id " + empid + " successfully deleted"),HttpStatus.OK);
		} else
			return new ResponseEntity<AppResponse>(new AppResponse("DELETEFAIL", "Employee with id " + empid + " not found"),HttpStatus.BAD_REQUEST);
	}

	@GetMapping("{eid}")
	public ResponseEntity<?> getEmployee(@PathVariable("eid") int empid) {

		Optional<Employee> opt = repo.findById(empid);

		if (opt.isPresent())
			return new ResponseEntity<Employee>(opt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<AppResponse>(	new AppResponse("NOTFND", "Employee with id " + empid + " is not found"), HttpStatus.NOT_FOUND);
	}


	@GetMapping
	public ResponseEntity<?> getAllEmployee() {
		List<Employee> list = repo.findAll();

		if (list.size() == 0) {
			return new ResponseEntity<AppResponse>(new AppResponse("GETFAIL", "No employee exists in database"),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
	
	
}
	

