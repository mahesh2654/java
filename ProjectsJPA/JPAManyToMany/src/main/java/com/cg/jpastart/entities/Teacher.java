package com.cg.jpastart.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "teacher_master")
public class Teacher {

	@Id
	private int id;
	@Column(name = "name", length = 20)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teacher_student", joinColumns = { @JoinColumn(name = "teacher_id") }, inverseJoinColumns = { @JoinColumn(name = "student_id") })
	private Set<Student> students = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		this.getStudents().add(student);
	}
	
	public void show() {
		System.out.println("Teacher Id: "+id);
		System.out.println("Teacher Name: "+name);
		System.out.println("Students: ");
		for(Student s: students) {
			System.out.println("\tId: "+s.getId()+ " Name: "+ s.getName()+ " Marks: "+ s.getMarks());
		}
	}
}

	
