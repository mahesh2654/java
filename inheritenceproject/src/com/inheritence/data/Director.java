package com.inheritence.data;

public class Director  extends Employee {

	
	private String clientCode;

	public Director(int empId, String name, float salary, String clientCode) {
		super(empId, name, salary);
		this.clientCode = clientCode;
	}
	
	public int getAllowancePercent() {
		return 20;
	}
	
	public void display() {
		
		System.out.println("Director details");
		super.display();
		System.out.println("Clent: "+clientCode);
	}

}
