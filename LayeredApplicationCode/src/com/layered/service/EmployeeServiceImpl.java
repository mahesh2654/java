package com.layered.service;

import java.util.ArrayList;
import java.util.List;

import com.layered.dao.EmployeeDao;
import com.layered.dao.EmployeeDaoMapImpl;
import com.layered.entity.Employee;
import com.layered.exceptions.DataNotFoundException;
import com.layered.exceptions.SaveDataException;
import com.layered.exceptions.ServiceException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao = new EmployeeDaoMapImpl();

	@Override
	public Employee getEmployee(int empId) {

		Employee x = dao.getEmployee(empId);
		return x;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = dao.getAllEmployees();
		return list;
	}

	@Override
	public void raiseSalary(int empId, float percent) throws ServiceException {
		// get employee
		// change salary
		// update

		Employee x = dao.getEmployee(empId);
		if (x == null)
			throw new ServiceException("Employee with id " + empId + " not found");

		float existingSalary = x.getSalary();
		float newSalary = existingSalary + existingSalary * percent / 100;
		x.setSalary(newSalary);
		try {
			dao.updateEmployee(x);
		} catch (DataNotFoundException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public float getTotalSalary() {

		float total = 0;
		List<Employee> emps = dao.getAllEmployees();
		for (Employee e : emps) {
			total = total + e.getSalary();
		}
		return total;
	}

	@Override
	public void deleteEmployee(int empId) throws ServiceException {
		
		try {
			dao.deleteEmployee(empId);
		} catch (DataNotFoundException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllwithSalaryRange(float min, float max) {
		
		List<Employee> list=dao.getAllEmployees();
		List<Employee> list1 = new ArrayList<Employee>();
		for(Employee x: list) {
			if(x.getSalary()>= min && x.getSalary()<=max)
				list1.add(x);
		}
		return list1;
	}

	@Override
	public void createEmployee(Employee e) throws ServiceException {
		
		try {
			dao.saveEmployee(e);
		} catch (SaveDataException e1) {

			throw new ServiceException(e1.getMessage());
		}
		
	}

}
