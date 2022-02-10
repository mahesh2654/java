package com.deloitte.trg.data;

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

	public void display() {
		super.display();
		System.out.println("Project: "+project);
	}

	@Override
	public float getAllowance() {
		return getSalary()*0.15f;
	}

}
