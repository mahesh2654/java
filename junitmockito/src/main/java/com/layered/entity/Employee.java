package com.layered.entity;

public class Employee  implements Comparable<Employee>{
	
	private int empId;
	private String name;
	private float salary;
	
	public Employee(int empId, String name, float salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
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

	@Override
	public String toString() {
		return "EmpId: " + empId + " Name: " + name + " Salary: " + salary;
	}

	@Override
	public int compareTo(Employee e) {

		return this.empId-e.empId;
	}
	

}
