package com.trg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trg.model.Employee;

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		List<Employee> list = (List<Employee>) request.getAttribute("emps");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<table border='1'>");
		pw.println("<tr>");

		pw.println("<th>EmpId</th>");
		pw.println("<th>Name</th>");
		pw.println("<th>Salary</th>");
		pw.println("</tr>");

		for (Employee x : list) {
			pw.println("<tr>");

			pw.println("<th>"+x.getEmpId()+"</th>");
			pw.println("<th>"+x.getName()+"</th>");
			pw.println("<th>"+x.getSalary()+"</th>");
			pw.println("</tr>");
		}
		
		pw.println("</table>");
		
		pw.println("<a href='emp.html'>Back</a>");
		pw.println("</body>");
		pw.println("</httml>");
		pw.close();

	}

}
