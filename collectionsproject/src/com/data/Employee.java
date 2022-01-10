package com.data;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Employee {

	private int empId;
	private String name;
	private float salary;
	private char gender;

	public Employee(int empId, String name, float salary, char gender) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
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
		if (salary < this.salary)
			System.out.println("Salary cannot be lowered");
		else
			this.salary = salary;
	}

	public String getGender() {
		switch (this.gender) {
		case 'M':
			return "Male";
		case 'F':
			return "Female";
		default:
			return "Unknown";
		}
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId;
	}

	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");

		return "EmpId: " + empId + " Name: " + name + " Salary: " + salary + " Gender: " + getGender();
	}

}
