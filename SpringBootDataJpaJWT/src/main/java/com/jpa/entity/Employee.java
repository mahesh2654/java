package com.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "emp")

public class Employee {
	@Id
	@Column(name = "empid")
	private int empid;

	@NotNull(message = "Name is Required")
	@Length(min = 5, max = 20,message="Length of name should be between 5 and 20")
	private String name;

	@Range(min = 10000, max = 35000,message="Salary should be in the range of 10000 and 35000")
	
	private float salary;

	public Employee() {

	}

	
	public Employee(int empid,String name, float salary) {
		super();
		this.empid=empid;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
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
		return "EmpId=" + empid + ", name=" + name + ", salary=" + salary;
	}

}
