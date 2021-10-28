package com.inheritence.data;

public class Manager extends Employee {

	private String project;

	public Manager(int empId, String name, float salary, String project) {
		super(empId, name, salary);
		this.project = project;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public int getAllowancePercent() {
		return 15;
	}
	
	public void display() {

		
		System.out.println("Manager Details");
		super.display();

		System.out.println("Project: " + project);
	}
	

}
