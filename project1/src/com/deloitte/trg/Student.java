package com.deloitte.trg;

public class Student {

	private int studentId;
	private String name;
	private float marks;

	// constructor typically used to initialize the data
	public Student(int studentId, String name, float marks) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Hello world";
	}
	
	
	public  boolean  isPass() {
	   if(marks > 45)
		   return true;
	   else
		   return false;
	}

}
