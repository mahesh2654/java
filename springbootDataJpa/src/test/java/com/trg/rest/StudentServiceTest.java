package com.trg.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.mapping.AccessOptions.GetOptions.GetNulls;

import com.jpa.StudentRepository;
import com.trg.crud.exceptions.StudentException;
import com.trg.student.data.Student;
import com.trg.student.service.StudentService;
import com.trg.student.service.StudentServiceImpl;

class StudentServiceTest {

	StudentRepository repo = Mockito.mock(StudentRepository.class);

	StudentService service = new StudentServiceImpl(repo);

	@Test
	public void testGetStudent100() {

		when(repo.getOne(100)).thenReturn(new Student(100, "Abcd", LocalDate.of(1998, 10, 21), 51.5));
		Student s = service.getStudent(100);

		assertEquals("Abcd", s.getName());
	}

	
	@Test
	public void testGetStudent999() {

		when(repo.getOne(999)).thenThrow(EntityNotFoundException.class);
		
		try {
			Student s= repo.getOne(999);
			fail("Not throwing exception for student 999");
		}
		catch(EntityNotFoundException ex) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testSaveStudent() {

		when(repo.existsById(100)).thenReturn(true);

		Student s = new Student(100, "Abcd", LocalDate.of(1998, 10, 21), 51.5);
		try {
			service.saveStudent(s);
			fail("trying to save duplicate data");
		} catch (StudentException ex) {
			assertTrue(true);
		}
	}

	@Test
	public void testGettopper() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(100, "Suresh", LocalDate.of(1999, 12, 5), 87.7));
		list.add(new Student(200, "Girish", LocalDate.of(2001, 12, 5), 56.7));
		list.add(new Student(300, "Satish", LocalDate.of(2002, 1, 25), 46.5));
		list.add(new Student(400, "Ganesh", LocalDate.of(2002, 10, 15), 91.7));
		
		when(repo.findAll()).thenReturn(list);
		
		Student st = service.getTopper();
		
		assertEquals("Ganesh",st.getName());
		
		
	}
}
