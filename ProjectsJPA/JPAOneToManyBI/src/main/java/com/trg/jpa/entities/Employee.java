package com.trg.jpa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_TBL")
public class Employee {

	@Id
	private int empId;
	@Column(length = 20)
	private String name;
	private float salary;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_fk")
	private Department department;
	
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "EempId=" + empId + ", name=" + name + ", salary=" + salary 
				+ " DeptId: "+department.getDeptId()+ " DeptName: "+department.getDeptName();
	}
	
	
}
