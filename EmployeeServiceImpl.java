package com.app.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.data.Employee;
import com.app.exceptions.DataNotFoundException;
import com.app.exceptions.DuplicateEmployeeException;
import com.app.exceptions.ServiceException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public Employee getOneEmployee(int eid) {

		return dao.getEmployee(eid);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return dao.getAllEmployees();
	}

	@Override
	public void deleteEmployee(int eid) throws ServiceException {
		
		try {
			dao.deleteEmployee(eid);
		} catch (DataNotFoundException e) {
			
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void changeSalary(int eid, float salary) throws ServiceException {
		
		Employee e = dao.getEmployee(eid);
		if(e == null)
			throw new ServiceException("Employee to update not found");
		e.setSalary(salary);
		
		try {
			dao.updateEmployee(e);
		} catch (DataNotFoundException e1) {
			throw new ServiceException(e1.getMessage());
		}

	}

	@Override
	public void addEmployee(Employee e) throws ServiceException {
		
		try {
			dao.save(e);
		} catch (DuplicateEmployeeException e1) {
			throw new ServiceException(e1.getMessage());
		}

	}

	@Override
	public List<Employee> getEmployeeOnsalary(float salary) {
		List<Employee> list = dao.getAllEmployees();
		
		List<Employee> list1 =
		list.stream()
		.filter(e-> e.getSalary() > salary)
		.collect(Collectors.toList());
		
		return list1;
	}

	@Override
	public Employee getHighestPaidEmployee() {
		List<Employee> list = dao.getAllEmployees();
		
		Employee x =	
		list.stream()
		.sorted(Comparator.comparing(Employee::getSalary).reversed())
		.limit(1)
		.collect(Collectors.toList())
		.get(0);
		
		return x;
	}

}
