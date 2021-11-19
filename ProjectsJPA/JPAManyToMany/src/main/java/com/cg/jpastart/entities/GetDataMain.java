package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetDataMain {

	public static void main(String[] args) {

		// change hibernate.hbm2ddl.auto propery to update or none before executing this class
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();

		System.out.println("================ Details of Teacher 100===========");
		Teacher teacher = em.find(Teacher.class, 100);

		teacher.show();

		System.out.println("==============Details of Student 2==========================");

		Student student = em.find(Student.class, 2);
		student.show();
		em.close();
		emf.close();
	}
}
