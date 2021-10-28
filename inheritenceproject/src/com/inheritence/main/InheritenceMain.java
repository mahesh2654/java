package com.inheritence.main;

import com.inheritence.data.Director;
import com.inheritence.data.Employee;
import com.inheritence.data.Manager;

public class InheritenceMain {

	public static void main(String[] args) {

		Employee e = new Employee(100, "Suresh", 25000);

		Manager mgr = new Manager(200, "Rajesh", 25000, "Bankproject");
		Director dir = new Director(300, "Kumar", 50000, "FaceBook");
		showSalaryDetails(e);
		System.out.println("================================");
		showSalaryDetails(mgr);
		System.out.println("================================");
		showSalaryDetails(dir);

	}

	static void showSalaryDetails(Employee e) {

		float allowance = e.getSalary() * e.getAllowancePercent() / 100;
		float totSalary = e.getSalary() + allowance;

		e.display();

		System.out.println("Allowance: " + allowance);
		System.out.println("Total salary: " + totSalary);
	}

}
