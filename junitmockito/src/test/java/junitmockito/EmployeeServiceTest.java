package junitmockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.layered.dao.EmployeeDao;
import com.layered.entity.Employee;
import com.layered.exceptions.DataNotFoundException;
import com.layered.exceptions.ServiceException;
import com.layered.service.EmployeeServiceImpl;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
	
	@Mock
	EmployeeDao dao;
	
	@InjectMocks
	EmployeeServiceImpl service;
	
	@Test
	public void totalSalaryTest() {
		
		List<Employee> list=new ArrayList<Employee>();
		list.add(new Employee(100,"abcd",3500));
		list.add(new Employee(200,"abcd",8000));
		list.add(new Employee(300,"abcd",10000));
		list.add(new Employee(400,"abcd",7000));
		
		//let the mock dao object return the list
		when(dao.getAllEmployees()).thenReturn(list);
		
		double totalSalary = service.getTotalSalary();
		
		double expectedTotal=28500;
		
		assertEquals(expectedTotal,totalSalary);
		
	}
	
	@Test
	public void getOnsalaryRangeTest() {
		List<Employee> list=new ArrayList<Employee>();
		list.add(new Employee(100,"abcd",3500));
		list.add(new Employee(200,"abcd",8000));
		list.add(new Employee(300,"abcd",10000));
		list.add(new Employee(400,"abcd",7000));

		when(dao.getAllEmployees()).thenReturn(list);
		
		List<Employee> salList=service.getAllwithSalaryRange(8000, 12000);
		assertEquals(2,salList.size());
	}
	@Test
	void deleteTest() throws DataNotFoundException {
		Mockito.doThrow(new DataNotFoundException("employee 999 not found")).when(dao).deleteEmployee(999);

		try {
			service.deleteEmployee(999);
			fail("exception not thrown");
		} catch (ServiceException e) {

		}
	}

	@Test
	public void checkHighestPaid() {
		List<Employee> list=new ArrayList<Employee>();
		list.add(new Employee(100,"abcd",3500));
		list.add(new Employee(200,"abcd",8000));
		list.add(new Employee(300,"abcd",10000));
		list.add(new Employee(400,"abcd",7000));
		
		when(dao.getAllEmployees()).thenReturn(list);
		
		Employee x= service.getHighestPaidEmployee();
		
		assertEquals(300, x.getEmpId());
	}
}
