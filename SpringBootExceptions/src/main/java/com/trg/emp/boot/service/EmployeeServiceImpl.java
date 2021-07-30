package com.trg.emp.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.capgemini.trg.exceptions.DuplicateEmployeeException;
import com.trg.emp.boot.dao.EmployeeDao;
import com.trg.emp.boot.dto.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;

	@Override
	public Employee get(int id) {

		return dao.getEmployee(id);
	}

	@Override
	public List<Employee> getAll() {
		return dao.getAllEmployees();
	}

	@Override
	public boolean add(Employee e) {

		dao.save(e);

		return true;

	}

	@Override
	public boolean update(Employee e) {

		return dao.update(e);
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

}