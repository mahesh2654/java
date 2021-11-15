package junit.mockito;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import com.app.dao.EmployeeDao;
import com.app.data.Employee;
import com.app.exceptions.DataNotFoundException;
import com.app.exceptions.ServiceException;
import com.app.service.EmployeeService;
import com.app.service.EmployeeServiceImpl;

class ServiceTest {

	EmployeeDao dao = Mockito.mock(EmployeeDao.class);

	EmployeeService service;

	@BeforeEach
	public void create() {

		service = new EmployeeServiceImpl(dao);
	}

	public void endIt() {
		service.close();
	}

	@Test
	void deleteTest() {
		Mockito.doThrow(new DataNotFoundException("employee 999 not found")).when(dao).deleteEmployee(999);

		try {
			service.deleteEmployee(999);
			fail("exception not thrown");

		} catch (ServiceException e) {

		}
	}

	@Test
	void testHighestPaid() {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(100, "abcd", 5600));
		list.add(new Employee(200, "hello", 9000));
		list.add(new Employee(300, "abcd", 4000));

		when(dao.getAllEmployees()).thenReturn(list);

		Employee e = service.getHighestPaidEmployee();

		assertEquals(200, e.getEmpId());
	}

}