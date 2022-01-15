package com.layered.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.layered.entity.Employee;
import com.layered.exceptions.DataNotFoundException;
import com.layered.exceptions.SaveDataException;

public class EmployeeJdbcDaoImpl implements EmployeeDao {

	Connection con;

	public EmployeeJdbcDaoImpl() {

		Properties prop = new Properties();
		try {
			prop.load(new FileReader("jdbc.properties"));

			String dr = prop.getProperty("driver");
			String url = prop.getProperty("connectString");
			String user = prop.getProperty("userName");
			String password = prop.getProperty("password");

			Class.forName(dr);
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			System.out.println("properties file not found");
			System.exit(0);
		}
	}

	@Override
	public void saveEmployee(Employee e) throws SaveDataException {

		try {
			PreparedStatement pst = con.prepareStatement("insert into empsml values(?,?,?)");
			int eid = e.getEmpId();
			String nm = e.getName();
			float sal = e.getSalary();

			pst.setInt(1, eid);
			pst.setString(2, nm);
			pst.setFloat(3, sal);

			pst.executeUpdate();

		} catch (SQLException e1) {
			if (e1.getErrorCode() == 1) {
				throw new SaveDataException("Employee eith id " + e.getEmpId() + " already exists");
			}
			throw new SaveDataException(e1.getMessage());
		}

	}

	@Override
	public Employee getEmployee(int empId) {

		try {
			PreparedStatement pst = con.prepareStatement("select * from empsml where empid=?");

			pst.setInt(1, empId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				int eid = rs.getInt(1);
				String nm = rs.getString(2);
				float sal = rs.getFloat(3);
				Employee e = new Employee(eid, nm, sal);
				return e;
			} else
				return null;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from empsml");
			List<Employee> list = new ArrayList<Employee>();
			while (rs.next()) {
				int eid = rs.getInt(1);
				String nm = rs.getString(2);
				float sal = rs.getFloat(3);
				Employee e = new Employee(eid, nm, sal);
				list.add(e);
			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateEmployee(Employee e) throws DataNotFoundException {
		try {
			PreparedStatement pst = con.prepareStatement("update empsml set name=? , salary=? where empid=?");
			pst.setString(1, e.getName());
			pst.setFloat(2, e.getSalary());
			pst.setInt(3, e.getEmpId());
			int count = pst.executeUpdate();
			if (count == 0)
				throw new DataNotFoundException("Employee data with id " + e.getEmpId() + " to udate not found");

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(int empId) throws DataNotFoundException {
		try {
			PreparedStatement pst = con.prepareStatement("delete from empsml where empid=?");
	
			pst.setInt(1, empId);
			int count = pst.executeUpdate();
			if (count == 0)
				throw new DataNotFoundException("Employee data with id " + empId + " to delete not found");

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}

	@Override
	public void finalize() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}