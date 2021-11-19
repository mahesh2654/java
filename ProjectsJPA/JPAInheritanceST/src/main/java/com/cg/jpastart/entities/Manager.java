package com.cg.jpastart.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MGR") // value for manager rows in Discriminator column
public class Manager extends Employee {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 20)
	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return super.toString() + " DepartmentName: " + departmentName;
	}

}
