package com.trg.student.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.StudentRepository;
import com.trg.crud.exceptions.StudentException;

import com.trg.student.data.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repo;
	

	public StudentServiceImpl(StudentRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Student getStudent(int id) {
		return repo.getOne(id);
	}

	@Override
	public void raiseMarks(int id, double percent) throws StudentException {
		Student s = repo.getOne(id);
		if (s == null)
			throw new StudentException("Student with id " + id + " does not exist");

		double marks = s.getMarks();
		double newMarks = marks + marks * percent / 100;
		s.setMarks(newMarks);
		repo.save(s);
	}

	@Override
	public void deleteStudent(int id) throws StudentException {
		if (repo.existsById(id))
			repo.deleteById(id);
		else
			throw new StudentException("Student with id " + id + "does not exist");
	}

	@Override
	public void saveStudent(Student s) {
		if (repo.existsById(s.getStudentId()))
			throw new StudentException("Student with id " + s.getStudentId() + "already exits");
		else
			repo.save(s);

	}

	@Override
	public List<Student> getAllStudents() {

		return repo.findAll();
	}

	@Override
	public List<Student> getQulifiedStudents() {

		List<Student> list = repo.findAll();

		List<Student> qualifiedList = new ArrayList<Student>();

		for (Student s : list) {
			if (s.getMarks() >= 40)
				qualifiedList.add(s);
		}
		return qualifiedList;
	}

	@Override
	public List<Student> getStudentsOnAge(int age) {
		List<Student> list = repo.findAll();

		List<Student> ageList = new ArrayList<Student>();

		for (Student s : list) {

			LocalDate dob = s.getDateofBirth();
			Period p = Period.between(dob, LocalDate.now());
			int studentAge = p.getYears();
			if (studentAge < age)
				ageList.add(s);
		}
		return ageList;
	}

	public Student getTopper() {
		List<Student> list = repo.findAll();

		Student topper = list.get(0);

		for (Student s : list) {
			if (s.getMarks() > topper.getMarks())
				topper = s;
		}

		return topper;
	}

	@Override
	public void updateStudent(Student s) throws StudentException {

		if (repo.existsById(s.getStudentId()))
			repo.save(s);
		else
			throw new StudentException("Student with id " + s.getStudentId() + "does not exist");
	}
}
