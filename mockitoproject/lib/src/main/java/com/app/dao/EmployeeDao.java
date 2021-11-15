package com.app.dao;

import java.util.List;

import com.app.data.Employee;
import com.app.exceptions.DataNotFoundException;
import com.app.exceptions.DuplicateEmployeeException;

public interface EmployeeDao {
	
	void save(Employee e) throws DuplicateEmployeeException;
	Employee getEmployee(int empId);
	List<Employee> getAllEmployees();
	void updateEmployee(Employee e) throws DataNotFoundException;
	void deleteEmployee(int empId)  throws DataNotFoundException;
	void terminate();
}
