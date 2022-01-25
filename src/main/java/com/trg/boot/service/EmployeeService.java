package com.trg.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trg.boot.entity.Employee;


@Service
public interface EmployeeService {

	Employee getEmployee(int empId);

	List<Employee> getAllEmployees();

	void updateEmployee(Employee e);

	void deleteEmployee(int empId);

	void createEmployee(Employee e);

}
