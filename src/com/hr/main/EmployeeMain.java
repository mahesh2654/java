package com.hr.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.hr.data.Employee;

public class EmployeeMain {

	public static void main(String[] args) {

		Employee e1 = getEmployee();

		System.out.println("Age: " + e1.getAge());

		System.out.println(e1);

	}

	static Employee getEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter empid,name,salary,gender(M/F), dob separated with Comma");
		
		String text = sc.nextLine();
		sc.close();

		String s[] = text.split(",");

		int eid = Integer.parseInt(s[0]);
		float salary = Float.parseFloat(s[2]);
		char gender = s[3].charAt(0);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dob = LocalDate.parse(s[4], df);

		return new Employee(eid, s[1], salary, dob, gender);
	}
}
