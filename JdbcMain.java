import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
	//	Class.forName("org.postgresql.Driver");
	
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","postgres");
		System.out.println("Connection created");
		Statement st= conn.createStatement();
		//st.executeUpdate("insert into employee values(300,'Ramraj',19000)");
		
		ResultSet rs = st.executeQuery("select * from employee");
		while(rs.next()){
			System.out.println(rs.getInt("empid")+"\t"+rs.getString("name")+"\t"+rs.getFloat("salary"));
		}
		conn.close();

	}

}
