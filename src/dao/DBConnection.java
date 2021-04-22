package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private final static String URL = "jdbc:mysql://localhost:3306/hotel_reservation"; 
	
	private final static String USERNAME = "root"; 
	private final static String PASSWORD = "TomKipVal8?"; 
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD); 
		
	}

}
