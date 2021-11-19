package com.trg.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.trg.jpa.entities.Department;
import com.trg.jpa.entities.Employee;

public class OneToManyMain2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ONETOMANYPU");
		EntityManager em = emf.createEntityManager();
		
		Department d1 = em.find(Department.class,10);
		
		System.out.println(d1);
		
		
		Employee e1 = em.find(Employee.class,100);
		Employee e2 = em.find(Employee.class,200);
		
		System.out.println(e1);
		System.out.println(e2);

	}

}
