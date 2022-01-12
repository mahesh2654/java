import java.util.List;
import java.util.Scanner;

import com.layered.dao.EmployeeDao;
import com.layered.dao.EmployeeDaoMapImpl;
import com.layered.entity.Employee;
import com.layered.exceptions.ServiceException;
import com.layered.service.EmployeeService;
import com.layered.service.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeServiceImpl();
/*		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter employee id");
		int eid = sc.nextInt();
		Employee x= service.getEmployee(eid);
		if(x != null)
			System.out.println(x);
		else
			System.out.println("Employee not found");
		
		System.out.println("===================List of all employees=================");
		List<Employee> lst=service.getAllEmployees();
		for(Employee e : lst)
			System.out.println(e);
		
		System.out.println("=================changing salary========================");
		System.out.println("enter low salary and high salary");
		float low = sc.nextFloat();
		float high=sc.nextFloat();
		
		lst=service.getAllwithSalaryRange(low, high);
		for(Employee e : lst)
			System.out.println(e);
		System.out.println("======================Delete employee====================");
		System.out.println("Enter empid to delete");
		eid=sc.nextInt();
		try {
			service.deleteEmployee(eid);
			System.out.println("Employee object successfully deleted");
		} catch (ServiceException e1) {
			System.out.println("Delete fail "+e1.getMessage());
		}
		
		*/
		Employee e1=new Employee(222,"abcde",40000);
		try {
			service.createEmployee(e1);
			System.out.println("Data successfully saved");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		List<Employee> lst=service.getAllEmployees();
		for(Employee e : lst)
			System.out.println(e);
	}
	

}
