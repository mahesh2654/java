package com.hr.data;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Employee {

	private int empId;
	private String name;
	private float salary;
	private LocalDate dob;
	private char gender;

	public Employee(int empId, String name, float salary, LocalDate dob, char gender) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
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

	public LocalDate getDob() {
		return dob;
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

		return "EmpId: " + empId + "\nName: " + name + "\nSalary: " + salary + "\nDob: " + dob.format(df) + "\nGender: "
				+ getGender();
	}
	
	public int getAge() {
		Period p = Period.between(dob, LocalDate.now());
		int age = p.getYears();
		return age;
	}

	public static Employee createEmployee() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter Emp id: ");
		String empIdStr = sc.nextLine();
		System.out.print("Enter Name: ");
		String name=sc.nextLine();
		System.out.print("Enter Salary: ");
		String salStr =sc.nextLine();
		System.out.print("Enter gender M or F: ");
		String genderStr = sc.nextLine();
		System.out.print("Enter DOB (dd/MM/yyyy): ");
		String dobStr=sc.nextLine();
		
		sc.close();
		
		int eid=Integer.parseInt(empIdStr);
		float salary=Float.parseFloat(salStr);
		char gender=genderStr.charAt(0);
		DateTimeFormatter  df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dob = LocalDate.parse(dobStr, df );
				
	
		return new Employee(eid, name, salary, dob, gender);
	}

}
