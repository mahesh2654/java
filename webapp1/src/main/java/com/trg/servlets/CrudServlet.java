package com.trg.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trg.model.Employee;

/**
 * Servlet implementation class CrudServlet
 */
public class CrudServlet extends HttpServlet {

	Map<Integer, Employee> data;

	public CrudServlet() {
		data = new HashMap<Integer, Employee>();

		data.put(100, new Employee(100, "Abhishek", 23000));
		data.put(200, new Employee(200, "Birbal", 34000));
		data.put(300, new Employee(300, "Charlie", 13000));
		data.put(400, new Employee(400, "Deepak", 14000));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String req= request.getParameter("request");
		if(req==null) {
			processAllEmpRequest(request,response);
		}
				
		String str1 = request.getParameter("empid");
		String name = request.getParameter("name");
		String str2 = request.getParameter("salary");

		int empid = Integer.parseInt(str1);
		float salary = Float.parseFloat(str2);

		System.out.println(empid + "   " + name + "   " + salary);

		String message = "";
		if (data.containsKey(empid)) {
			message = "Employee id already exists";
		} else {
			data.put(empid, new Employee(empid, name, salary));
			message = "Employee data successfully saved";
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("response.jsp");
		request.setAttribute("response", message);
		
		rd.forward(request, response);
	}

	void processAllEmpRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<Employee> col = data.values();
		
		List<Employee> list = new ArrayList<Employee>();
		
		list.addAll(col);
		
		request.setAttribute("emps", list);
		RequestDispatcher rd= request.getRequestDispatcher("showList");
		
		rd.forward(request, response);

		
	}
}
