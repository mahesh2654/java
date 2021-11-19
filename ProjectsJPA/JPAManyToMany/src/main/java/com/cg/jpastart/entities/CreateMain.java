package com.cg.jpastart.entities;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateMain {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		// first define few students

		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Student 1");
		s1.setMarks(75.5);

		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Student 2");
		s2.setMarks(85.5);

		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Student 3");
		s3.setMarks(56.5);

		Student s4 = new Student();
		s4.setId(4);
		s4.setName("Student 4");
		s4.setMarks(90.0);

		// now define first teacher and add few students
		Teacher t1 = new Teacher();

		t1.setId(100);
		t1.setName("Teacher 1");

		t1.addStudent(s1);
		t1.addStudent(s2);
		t1.addStudent(s4);

		// now define second teacher and add few students
		Teacher t2 = new Teacher();

		t2.setId(200);
		t2.setName("Teacher 2");

		t2.addStudent(s2);
		t2.addStudent(s3);
		t2.addStudent(s4);

		// save orders using entity manager

		em.persist(t1);
		em.persist(t2);

		System.out.println("Added teachers along with associated students to database.");

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
