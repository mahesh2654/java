

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		

	}
	
	static List<Employee> getList(){
		String url="jdbc:oracle:thin:@localhost:1521/xe";
		String unm ="system";
		String pwd="ramana";
		List<Employee> list = new ArrayList<Employee>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver loaded");
			Connection con = DriverManager.getConnection(url,unm,pwd);
			System.out.println("connection created");
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from employee");
		
			while(rs.next()) {
			Employee e= new Employee(rs.getInt(1),rs.getString(2),
					rs.getFloat(3),rs.getDate(4),
					   rs.getInt(5),rs.getString(6));
			list.add(e);
			}
			con.close();
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
