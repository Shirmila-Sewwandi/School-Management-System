package examRegistration;

import java.sql.*;


public class SqlXamp {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student","root","");
			if(!con.isClosed())
				System.out.println("Successfully connected to MySql server...");
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		finally {
			try {
				if (con != null)
					con.close();
			}
			catch(SQLException e) {
				
			}
		}
	}

}
