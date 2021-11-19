package com.trg.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.trg.jpa.entities.Department;
import com.trg.jpa.entities.Employee;

public class OneToManyMain1 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ONETOMANYPU");
		EntityManager em = emf.createEntityManager();
		
		// create department 10
		Department d10 = new Department();
		d10.setDeptId(10);
		d10.setDeptName("Sales");
		
		// create Employee objects for department 10
		Employee emp100 = new Employee();
		emp100.setEmpId(100);
		emp100.setName("Suresh");
		emp100.setSalary(4500);
		emp100.setDepartment(d10);
		
		Employee emp300 = new Employee();
		emp300.setEmpId(300);
		emp300.setName("Satish");
		emp300.setSalary(6500);
		emp300.setDepartment(d10);
		
		Employee emp500 = new Employee();
		emp500.setEmpId(500);
		emp500.setName("Jahnavi");
		emp500.setSalary(8000);
		emp500.setDepartment(d10);
		
		// add all 3 employes to department 10
		d10.addEmployee(emp100);
		d10.addEmployee(emp300);
		d10.addEmployee(emp500);
		
		em.getTransaction().begin();
		em.persist(d10);             // Employee data automatically saved in emp_tbl
		em.getTransaction().commit();
		
	
		// create department 20
		Department d20 = new Department();
		d20.setDeptId(20);
		d20.setDeptName("HR");
		
		Employee emp200 = new Employee();
		emp200.setEmpId(200);
		emp200.setName("Ganesh");
		emp200.setSalary(5500);
		emp200.setDepartment(d20);
		
		Employee emp400 = new Employee();
		emp400.setEmpId(400);
		emp400.setName("Sridevi");
		emp400.setSalary(5000);
		emp400.setDepartment(d20);
		
		em.getTransaction().begin();
		em.persist(emp200);   // department data for deptid 20 is created in dpt_tbl
		em.persist(emp400);   // department data for deptid 20 is not created . It is only updated
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
