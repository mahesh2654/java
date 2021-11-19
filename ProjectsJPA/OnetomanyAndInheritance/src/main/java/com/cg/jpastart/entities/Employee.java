package com.cg.jpastart.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp_store")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // This annotation must be written only on parent class
@DiscriminatorColumn(name = "emp_type", discriminatorType = DiscriminatorType.CHAR) // additional column to differ
																						// parent and child
@DiscriminatorValue("E") // parent rows will have this value in Discriminator Column
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int employeeId;
	@Column(length = 20)
	private String name;
	private double salary;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_fk")
	
	private Department department;
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeId: " + employeeId + " Name: " + name + " Salary=" + salary;
	}

}
