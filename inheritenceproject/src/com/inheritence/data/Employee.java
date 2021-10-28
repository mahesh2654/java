package com.inheritence.data;

public class Employee {

	private int empId;
	private String name;
	private float salary;

	public Employee(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
		salary = 20000;
	}

	public Employee(int empId, String name, float salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public int getAllowancePercent() {
		return 10;
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

	public void display() {
		System.out.println("Emp Id:" + empId);
		System.out.println("Name: " + name);
		System.out.println("Salary:" + salary);
	}

}
