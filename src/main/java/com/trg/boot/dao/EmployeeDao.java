package com.trg.boot.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trg.boot.entity.Employee;
import com.trg.boot.exceptions.DataNotFoundException;
import com.trg.boot.exceptions.SaveDataException;


@Service
public interface EmployeeDao {
	
	void saveEmployee(Employee e);
	Employee getEmployee(int empId);   // null returned if object not found
	List<Employee> getAllEmployees();
	void updateEmployee(Employee e) ;
	void deleteEmployee(int empId) ;

}
