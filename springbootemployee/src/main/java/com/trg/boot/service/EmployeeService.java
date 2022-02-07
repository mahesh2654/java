package com.trg.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trg.boot.entity.Employee;
import com.trg.boot.exceptions.EmployeeDuplicateException;
import com.trg.boot.exceptions.EmployeeNotFoundException;
import com.trg.boot.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	public List<Employee> getAllEmployees() {

		List<Employee> list = repository.findAll();
		return list;
	}

	public Employee getEmployee(int eid) {
		Optional<Employee> opt = repository.findById(eid);
		if (!opt.isPresent())
			throw new EmployeeNotFoundException("NOT_FND", "Employee data with id " + eid + " not found");
		return opt.get();
	}

	public void saveEmployee(Employee m) {
		if (repository.existsById(m.getEmpId()))
			throw new EmployeeDuplicateException("SAVE_FAIL", "Employee wiith id " + m.getEmpId() + " already exists");
		repository.save(m);
	}

	public void updateEmployee(Employee e) {
		if (repository.existsById(e.getEmpId()))
			repository.save(e);
		else
			throw new EmployeeNotFoundException("UPDT_FAIL",
					"Employee wiith id " + e.getEmpId() + " to update not found");

	}

	public void deleteEmployee(int mid) {
		if (repository.existsById(mid)) {
			repository.deleteById(mid);
		} else {
			throw new EmployeeNotFoundException("NOT_FND", "Employee data with id " + mid + " to delete not found");
		}

	}
}
