package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDao {
	
	
	private final String addReservation = "INSERT INTO reservations (user_id, room_id, arrival_date, departure_date) VALUES (?,?,?,?)"; 
	private final String updateReservationDates = "UPDATE reservations SET arrival_date = ?, departure_date = ? WHERE id = ?"; 
	private final String deleteReservation = "DELETE FROM reservations WHERE id = ?"; 
	private final String lastRow = "SELECT id FROM reservations ORDER BY id desc limit 1"; 

	public void createReservation(int userId, int roomId, String arrivalDate, String departureDate) throws SQLException {
		Connection connection = DBConnection.getConnection(); 
		PreparedStatement statement = connection.prepareStatement(addReservation); 
		statement.setInt(1, userId);
		statement.setInt(2, roomId);
		statement.setString(3, arrivalDate);
		statement.setString(4, departureDate);
		statement.execute(); 
		
	}

	public void modifyReservationDates(int reservationNumber, String arrivalDate, String departureDate) throws SQLException { 
		Connection connection = DBConnection.getConnection(); 
		PreparedStatement ps = connection.prepareStatement(updateReservationDates); 
		ps.setString(1, arrivalDate);
		ps.setString(2, departureDate);
		ps.setInt(3, reservationNumber);
		ps.executeUpdate(); 
		
	}

	public void deleteReservation(int reservationNumber) throws SQLException {
		Connection connection = DBConnection.getConnection(); 
		PreparedStatement statement = connection.prepareStatement(deleteReservation); 
		statement.setInt(1, reservationNumber);
		statement.executeUpdate(); 
		
	}
	
	public int getlastrow() throws SQLException { 
		Connection connection = DBConnection.getConnection(); 
		PreparedStatement ps = connection.prepareStatement(lastRow);
		ResultSet rs = ps.executeQuery(); 
		rs.next(); 
		return rs.getInt(1); 
		
	}

}
