

import java.sql.Date;

public class Employee {
	
	private int empId;
	private String name;
	private float salary;
	private Date dob;
	private int deptId;
	private String gender;
	
	public Employee(int empId, String name, float salary, Date dob, int deptId, String gender) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
		this.deptId = deptId;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "EmpId=" + empId + ", name=" + name + ", salary=" + salary + ", dob=" + dob + ", deptId="
				+ deptId + ", gender=" + gender;
	}
	
	
	

}
