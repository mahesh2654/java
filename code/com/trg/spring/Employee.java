package com.trg.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("beans.properties")
public class Employee {
	@Value("${employee.id}")
	private int empId;
	@Value("${employee.name}")
	private String name;
	@Value("${employee.salary}")
	private float salary;

	@Autowired
	@Qualifier("dept2")
	private Department dept;

	public Employee() {

	}

	public Employee(int empId, String name, float salary, Department dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
	}


}
