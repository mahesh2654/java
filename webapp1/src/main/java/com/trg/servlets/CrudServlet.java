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
import com.trg.service.EmployeeService;

/**
 * Servlet implementation class CrudServlet
 */
public class CrudServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			EmployeeService.processListRequest(request, response);
		} else {

			switch (action) {
			case "save":
				EmployeeService.processSaveRequest(request, response);
				break;
			case "getdata":
				EmployeeService.processGetDataRequest(request, response);
				break;
			case "delete":
				EmployeeService.processDeleteRequest(request, response);
			}
		}
	}

	
}
