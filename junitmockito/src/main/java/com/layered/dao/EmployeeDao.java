package com.layered.dao;

import java.util.List;

import com.layered.entity.Employee;
import com.layered.exceptions.DataNotFoundException;

import com.layered.exceptions.SaveDataException;

public interface EmployeeDao {
	
	void saveEmployee(Employee e) throws SaveDataException;
	Employee getEmployee(int empId);   // null returned if object not found
	List<Employee> getAllEmployees();
	void updateEmployee(Employee e)  throws DataNotFoundException;
	void deleteEmployee(int empId) throws DataNotFoundException;

}
