package net.codejava;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class DELETEUSER {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/first";
		String username = "root"; // database username
		String dbpassword ="razan11418"; // database password
		
		String user_name = "Jhon";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, username, dbpassword);
			String sql = "DELETE FROM users WHERE user_name=?";
			
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, user_name);
			
			
			int rows = stm.executeUpdate();
			if(rows >0 ) {
				System.out.println("the user's information has been deleted");
			}
			conn.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		

	}

}
