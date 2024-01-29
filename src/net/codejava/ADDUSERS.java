package net.codejava;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class ADDUSERS {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/first";
		String username = "root"; // database username
		String dbpassword ="razan11418"; // database password
		
		String user_name = "Razan";
		String email = "Razan@gmail.com";
		String password = "mySecret";
		String full_name = "razan nael tuhaimer";
		
		
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, username, dbpassword);
			String sql = "INSERT INTO users (user_name, email, full_name, password)"
					     + " VALUES (?,?,?,?)";
			
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, user_name);
			stm.setString(2, email);
			stm.setString(3, full_name);
			stm.setString(4, password);
			
			
			int rows = stm.executeUpdate();
			if(rows >0 ) {
				System.out.println("A new user has been inserted");
			}
			conn.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		

	}

}
