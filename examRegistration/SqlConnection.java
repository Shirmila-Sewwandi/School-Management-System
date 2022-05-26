package examRegistration;

import java.sql.*;
import javax.swing.JOptionPane;

public class SqlConnection {

	public static Connection getConnection(){  
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");
        } catch (Exception ex) {
            System.out.println("Connection Faild!: "+ex.getMessage());
        }      
        return con;
    }
	
	Connection con = getConnection();
	PreparedStatement ps,ps1,ps2;
	
	public ResultSet SaveToDataBase(String username,String password) {
		try {
//			String query = "INSERT INTO `users`(`userID`, `password`) VALUES (?,?)";
			String query = "SELECT * FROM `users` WHERE `userName` =? AND `password` =?";
			
			ps = con.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2,password);
			return ps.executeQuery();
		}
		catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		return null;
	}
	
	public ResultSet ShowResult() {	
		try {	
			String query2 = "SELECT * FROM `courses`";		
			ps1 = con.prepareStatement(query2);
			return ps1.executeQuery();		
		}	
		catch(Exception e) {
			System.out.println("Error: Error");
		}
		return null;
	}
	
	public ResultSet InsertData(String id,String year,String name,String course1,String course2,String course3,String course4,String course5) {
		try {
			String query3="INSERT INTO `student`(`IndexNumber`, `Name`, `Year`, `Course1`, `Course2`, `Course3`) "
					+ "VALUES (?,?,?,?,?,?)";
			ps2 = con.prepareStatement(query3);
			ps2.setString(1, id);
			ps2.setString(2, name);
			ps2.setString(3, year);
			ps2.setString(4, course1);
			ps2.setString(5, course2);
			ps2.setString(6, course3);
//			ps2.setString(7, course4);
//			ps2.setString(8, course5);
			
			ps2.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println("Error :"+e.getMessage());
		}
		return null;
		
	}
}
