package com.layered.service;

import java.util.List;

import com.layered.entity.Employee;
import com.layered.exceptions.ServiceException;

public interface EmployeeService {
	
	Employee getEmployee(int empId);
	List<Employee> getAllEmployees();
	void raiseSalary(int empId, float percent) throws ServiceException;
	double getTotalSalary();
	void deleteEmployee(int empId) throws ServiceException;
	List<Employee> getAllwithSalaryRange(float min, float max);
	void createEmployee(Employee e) throws ServiceException;
}
