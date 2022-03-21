package com.trg.service;


import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trg.model.Employee;

public class EmployeeService {
	static Map<Integer, Employee> data;

	static {
		data = new HashMap<Integer, Employee>();

		data.put(100, new Employee(100, "Abhishek", 23000));
		data.put(200, new Employee(200, "Birbal", 34000));
		data.put(300, new Employee(300, "Charlie", 13000));
		data.put(400, new Employee(400, "Deepak", 14000));
	}
	
	public static void processDeleteRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String str1 = request.getParameter("empid");
		int empid = Integer.parseInt(str1);

		String message = "";

		if (data.containsKey(empid)) {
			data.remove(empid);
			message = "Employee with id " + empid + " successfully deleted";
		} else {

			message = "Delete Fail!! Employee with id " + empid + " not found";
		}

		request.setAttribute("msg", message);
		RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
		rd.forward(request, response);
	}

	public static void processListRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Collection<Employee> col = data.values();

		// List<Employee> list = new ArrayList<Employee>();

		// list.addAll(col);

		request.setAttribute("emps", col);
		RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
		rd.forward(request, response);

	}

	public static void processSaveRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String str1 = request.getParameter("empid");
		String name = request.getParameter("name");
		String str2 = request.getParameter("salary");

		int empid = Integer.parseInt(str1);
		float salary = Float.parseFloat(str2);

		String message = "";

		if (data.containsKey(empid)) {
			message = "Employee id already exists";
		} else {
			data.put(empid, new Employee(empid, name, salary));
			message = "Employee data successfully saved";
		}

		request.setAttribute("msg", message);
		RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
		rd.forward(request, response);
	}

	static public void processGetDataRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String str1 = request.getParameter("empid");

		int empid = Integer.parseInt(str1);

		Employee e = data.get(empid);

		if (e == null) {
			RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
			request.setAttribute("msg", "Employee with id " + empid + " not found");

			rd.forward(request, response);
		}

		else {
			RequestDispatcher rd = request.getRequestDispatcher("empdetails.jsp");
			request.setAttribute("emp", e);

			rd.forward(request, response);
		}

	}
}
