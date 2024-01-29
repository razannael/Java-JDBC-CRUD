package net.codejava;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class UPDATEUSERDATA {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/first";
		String username = "root"; // database username
		String dbpassword ="razan11418"; // database password
		
		String user_name = "Jhon";
		String email = "jhon22@gmail.com";
		String password = "1234567";
		String full_name = "Jhon Deep";
		
		
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, username, dbpassword);
			String sql = "UPDATE users SET password=?, full_name=?, email=? WHERE user_name =?";
			
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, password);
			stm.setString(2, full_name);
			stm.setString(3, email);
			stm.setString(4, user_name);
			
			
			int rows = stm.executeUpdate();
			if(rows >0 ) {
				System.out.println("the user's information has been updated");
			}
			conn.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		

	}

}
