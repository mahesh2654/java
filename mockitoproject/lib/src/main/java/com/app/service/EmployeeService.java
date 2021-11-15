package com.app.service;

import java.util.List;

import com.app.data.Employee;
import com.app.exceptions.ServiceException;

public interface EmployeeService {
	
	Employee getOneEmployee(int eid);
	List<Employee> getAllEmployees();
	void deleteEmployee(int eid) throws ServiceException;
	void changeSalary(int eid, float salary) throws ServiceException;
	void addEmployee(Employee e) throws ServiceException;
	List<Employee> getEmployeeOnsalary(float salary);
	Employee getHighestPaidEmployee();
	void close();

}
