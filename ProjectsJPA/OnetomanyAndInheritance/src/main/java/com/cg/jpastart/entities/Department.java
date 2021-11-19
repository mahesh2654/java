package com.cg.jpastart.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPT_TBL")
public class Department {

	@Id
	private int deptId;
	@Column(length = 15)
	private String deptName;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	List<Employee> employees = new ArrayList<>();

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addEmployee(Employee e) {
		employees.add(e);
	}

	@Override
	public String toString() {

		String data = "DeptId " + deptId + " DeptName=" + deptName;
		for (Employee e : employees) {
			data = data + " \n ";
			if (e instanceof Director)
				data = data + "Director> ";
			else if (e instanceof Manager)
				data = data + "Manager> ";
			else
				data = data + "Employee> ";
			data += e;
		}
		return data;
	}

}
