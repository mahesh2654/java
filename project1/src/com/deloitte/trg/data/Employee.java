package com.deloitte.trg.data;

abstract public class Employee {

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

	abstract public float getAllowance();  // cannot define this method now. It has to be defined in subclasses(abstract method)
	
			// it is compusory to override abstract method. Otherwise child class also becomes abstract
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
	}

	public void display() {
		System.out.println("Emp Id: "+empId);
		System.out.println("Name: "+name);
		System.out.println("Salary: "+salary);
		System.out.println("Allowance: "+ getAllowance());
	}
	
	
}
