package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InheritanceMain {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Department dept = new Department();
		dept.setDeptId(111);
		dept.setDeptName("Sales dept");
		
		// create one employee
		Employee employee = new Employee();
		employee.setEmployeeId(100);
		employee.setName("John");
		employee.setSalary(5000);
		employee.setDepartment(dept);
		// em.persist(employee);

		// create one manager
		Manager manager = new Manager();
		manager.setEmployeeId(200);
		manager.setName("Trisha");
		manager.setSalary(8000);
		manager.setDepartmentName("Sales");
		manager.setDepartment(dept);
		// em.persist(manager);

		// create Director
		Director dir = new Director();
		dir.setEmployeeId(300);
		dir.setName("Ravi Kumar");
		dir.setSalary(45000);
		dir.setDepartmentName("All Depts");
		dir.setClient("General Motors");
		dir.setDepartment(dept);
		// em.persist(dir);
		
		dept.addEmployee(employee);
		dept.addEmployee(manager);
		dept.addEmployee(dir);
		
		em.persist(dept);
		
		em.getTransaction().commit();

		System.out.println("Added one employee and manager and director to database.");
		/*
		 * Employee e1 = em.find(Employee.class, 100); Manager m1 =
		 * em.find(Manager.class, 100); Director d1=em.find(Director.class, 300);
		 * 
		 * System.out.println(e1); System.out.println(m1); System.out.println(d1);
		 */

		Department dept1 = em.find(Department.class, 111);
		System.out.println(dept1);
		em.close();
		factory.close();
	}
}
