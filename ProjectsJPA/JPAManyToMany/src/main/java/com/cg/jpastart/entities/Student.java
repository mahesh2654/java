package com.cg.jpastart.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_master")
public class Student {

	@Id
	private int id;
	@Column(length = 20)
	private String name;
	private double marks;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="students")
	private Set<Teacher> teachers = new HashSet<>();
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
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeacherss(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	public void show() {
		System.out.println("Student Id: "+id);
		System.out.println("Student Name: "+name);
		System.out.println("Teacherss teaching this Student: ");
		for(Teacher t: teachers) {
			System.out.println("\tId: "+t.getId()+ " Name: "+ t.getName());
		}
	}
	
}