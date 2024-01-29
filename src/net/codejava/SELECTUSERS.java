package net.codejava;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SELECTUSERS {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/first";
		String username = "root"; // database username
		String dbpassword ="razan11418"; // database password
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, username, dbpassword);
			
			String sql = "SELECT * FROM users";
			Statement smt = conn.createStatement();
			ResultSet result = smt.executeQuery(sql);
			
			while(result.next()) {
				int userId = result.getInt("user_id");
				String user_name = result.getString("user_name");
				String full_name = result.getString("full_name");
				String email = result.getString("email");
				String password = result.getString("password");
				
				System.out.println(userId + ": " +user_name + ", "
						+full_name+ ", " + email+ ", " + password);
				System.out.println("===================================================================");
			}
			
			conn.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		

	}

}
