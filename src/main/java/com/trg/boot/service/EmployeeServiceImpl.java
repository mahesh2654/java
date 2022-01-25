package com.trg.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trg.boot.dao.EmployeeDao;

import com.trg.boot.dao.EmployeeJdbcDaoImpl;
import com.trg.boot.entity.Employee;
import com.trg.boot.exceptions.DataNotFoundException;
import com.trg.boot.exceptions.SaveDataException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;

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
	public void updateEmployee(Employee emp) {

		dao.updateEmployee(emp);

	}

	@Override
	public void deleteEmployee(int empId) {

		dao.deleteEmployee(empId);
	}

	@Override
	public void createEmployee(Employee e) {

		dao.saveEmployee(e);

	}

}
