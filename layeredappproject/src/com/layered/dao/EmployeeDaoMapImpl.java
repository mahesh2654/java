package com.layered.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.layered.entity.Employee;
import com.layered.exceptions.DataNotFoundException;
import com.layered.exceptions.SaveDataException;

public class EmployeeDaoMapImpl implements EmployeeDao {

	HashMap<Integer, Employee> data = new HashMap<Integer, Employee>();

	public EmployeeDaoMapImpl() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("employee.txt"));
			while (true) {
				String text = br.readLine();
				if (text == null)
					break;
				String fields[] = text.split(",");
				if (fields.length != 3) {
					System.out.println("Invalid data-->" + text);
					continue;
				}
				try {
					int eid = Integer.parseInt(fields[0]);
					float sal = Float.parseFloat(fields[2]);
					Employee e = new Employee(eid, fields[1], sal);
					if (data.containsKey(eid))
						System.out.println("Employee with id " + eid + " already exists");
					else
						data.put(eid, e);

				} catch (NumberFormatException ne) {
					System.out.println("Invalid numeric value--> " + text);
				}

			}
			br.close();
			System.out.println(data.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void saveEmployee(Employee e) throws SaveDataException {

		if (data.containsKey(e.getEmpId()))
			throw new SaveDataException("Employee eith id " + e.getEmpId() + " already exists");
		data.put(e.getEmpId(), e);
	}

	@Override
	public Employee getEmployee(int empId) {

		Employee e = data.get(empId);
		return e;
	}
	@Override
	public List<Employee> getAllEmployees() {

		Collection<Employee> col = data.values();
		List<Employee> list = new ArrayList<Employee>();
		list.addAll(col);
		Collections.sort(list);
		return list;
	}
	@Override
	public void updateEmployee(Employee e) throws DataNotFoundException {
		if (data.containsKey(e.getEmpId()))
			data.replace(e.getEmpId(), e);
		else
			throw new DataNotFoundException("Employee data with id " + e.getEmpId() + " to udate not found");
	}

	@Override
	public void deleteEmployee(int empId) throws DataNotFoundException {
		if (data.containsKey(empId))
			data.remove(empId);
		else
			throw new DataNotFoundException("Employee data with id " + empId + " to delete not found");

	}

}
