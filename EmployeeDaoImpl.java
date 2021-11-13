package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.data.Employee;
import com.app.exceptions.DataNotFoundException;
import com.app.exceptions.DatabaseException;
import com.app.exceptions.DuplicateEmployeeException;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection con;
	PreparedStatement createPst;
	PreparedStatement updatePst;
	PreparedStatement deletePst;
	PreparedStatement getPst;

	public EmployeeDaoImpl() throws DatabaseException {

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres");

			createPst = con.prepareStatement("insert into employee values(?,?,?)");
			updatePst = con.prepareStatement("update employee set name=?, salary=? where empid=?");
			deletePst = con.prepareStatement("delete from employee where empid=?");
			getPst = con.prepareStatement("select * from employee where empid=?");

		} catch (ClassNotFoundException e) {
			throw new DatabaseException(e.getMessage());

		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	@Override
	public void save(Employee e) throws DuplicateEmployeeException {
		try {
			createPst.setInt(1, e.getEmpId());
			createPst.setString(2, e.getName());
			createPst.setFloat(3, e.getSalary());

			createPst.executeUpdate();

		} catch (SQLException ex) {
			throw new DuplicateEmployeeException("Employee already exists");
		}

	}

	@Override
	public Employee getEmployee(int eid) {

		try {
			getPst.setInt(1, eid);
			ResultSet rs = getPst.executeQuery();
			if(rs.next()) {
				int empId = rs.getInt("empid");
				String name = rs.getString("name");
				float salary = rs.getFloat("salary");
				
				Employee e = new Employee(empId, name, salary);
				
				return e;
			}
			else
				return null;


		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> list = new ArrayList<Employee>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			while (rs.next()) {
				int empId = rs.getInt("empid");
				String name = rs.getString("name");
				float salary = rs.getFloat("salary");
				
				Employee e = new Employee(empId, name, salary);
				
				list.add(e);
			}
			return list;

		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public void updateEmployee(Employee e) throws DataNotFoundException {

		try {
			updatePst.setInt(3, e.getEmpId());
			updatePst.setString(1, e.getName());
			updatePst.setFloat(2, e.getSalary());

			int x = updatePst.executeUpdate();
			if (x == 0)
				throw new DataNotFoundException("Employee data to update not found");

		} catch (SQLException ex) {
			throw new DatabaseException(ex.getMessage());
		}
	}

	@Override
	public void deleteEmployee(int empId) throws DataNotFoundException {
		try {
			deletePst.setInt(1, empId);

			int x = deletePst.executeUpdate();
			if (x == 0)
				throw new DataNotFoundException("Employee to delete  not found");

		} catch (SQLException ex) {
			throw new DatabaseException(ex.getMessage());
		}
	}

}
