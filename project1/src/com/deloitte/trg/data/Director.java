package com.deloitte.trg.data;

public class Director extends Employee {
	
	private String account;
	

	public Director(int empId, String name, float salary, String account) {
		super(empId, name, salary);
		this.account=account;
	}


	public void display() {
		super.display();
		System.out.println("Client Account: "+account);
	}


	@Override
	public float getAllowance() {
	
		return getSalary()*.2f;
	}

	
}
