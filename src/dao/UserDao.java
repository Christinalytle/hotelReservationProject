package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	 
	private final String createAccount = "INSERT INTO users (first_name, last_name, email) VALUES (?,?,?)";
	private final String lastRow = "SELECT id FROM users u ORDER BY id desc limit 1"; 
	
	public void createAccount(String firstName, String lastName, String email) throws SQLException {
			Connection connection = DBConnection.getConnection(); 	
			PreparedStatement statement = connection.prepareStatement(createAccount); 
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, email);
			statement.execute();
		
	}

	public int getlastrow() throws SQLException { 
		Connection connection = DBConnection.getConnection(); 	
		PreparedStatement ps = connection.prepareStatement(lastRow);
		ResultSet rs = ps.executeQuery(); 
		rs.next(); 
		return rs.getInt(1); 
		
	}

}
