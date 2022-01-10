package com.maps;

import java.util.*;

import com.data.Employee;

public class EmployeeMap {

	public static void main(String[] args) {

		Employee[] emps = { 
				new Employee(100, "Suresh", 10000, 'M'), 
				new Employee(200, "Rajani", 12000, 'F'),
				new Employee(300, "Kumar", 25000, 'M'), 
				new Employee(400, "Kumari", 34000, 'F') };

		List<Employee> list = Arrays.asList(emps);

		Map<Integer, Employee> m = getMap(list);

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Enter employee id: ");
			int eid = sc.nextInt();
			if (eid == 0)
				break;
			Employee e = m.get(eid);
			if (e == null)
				System.out.println("Employee not found");
			else
				System.out.println(e);

		}
		System.out.println("Thank you Bye!!!!");

	}

	static Map<Integer, Employee> getMap(List<Employee> list) {

		Map<Integer, Employee> map = new TreeMap<Integer, Employee>();

		for (Employee e : list) {
			map.put(e.getEmpId(), e);
		}

		return map;

	}

}
