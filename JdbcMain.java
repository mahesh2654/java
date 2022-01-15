package com.sasken.jdbc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jdbc.data.Employee;

import oracle.jdbc.driver.OracleDriver;

public class JdbcMain1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileReader("jdbc.properties"));

		String dr = prop.getProperty("driver");
		String url = prop.getProperty("connectString");
		String user = prop.getProperty("userName");
		String password = prop.getProperty("password");

		try {
			Class.forName(dr);

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection created");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select empid,name,salary, salary*0.1 allowance from employee");
			// process result set

			List<Employee> list = new ArrayList<Employee>();
			while (rs.next()) {
				int eid = rs.getInt("empid");
				String nm = rs.getString("name");
				float sal = rs.getFloat(3);
				Employee emp = new Employee(eid, nm, sal);
				list.add(emp);
			}

			con.close();

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e:/emp.dat"));
			oos.writeObject(list);
			oos.close();

			System.out.println("all objects saved to file e:/emp.dat");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
