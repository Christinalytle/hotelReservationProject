package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Room;

public class RoomDao {
	
	
	private final String selectRooms = "SELECT * FROM rooms r WHERE id NOT IN (SELECT room_id FROM reservations rs WHERE (arrival_date <= ? AND departure_date >= ?))";;
	
	public List<Room> getRoomsByDate(String departureDate, String arrivalDate) throws SQLException {
		Connection connection = DBConnection.getConnection(); 
		PreparedStatement statement = connection.prepareStatement(selectRooms) ;
		statement.setString(1, departureDate);
		statement.setString(2, arrivalDate);
		ResultSet rs = statement.executeQuery(); 
		List<Room> rooms = new ArrayList<>(); {
			while (rs.next()) {
				int id = rs.getInt("id"); 
				String name = rs.getString("name"); 
				int occupancy = rs.getInt("occupancy"); 
				
				Room room = new Room(id, name, occupancy);
				rooms.add(room); 
			}
	return rooms; 			
	}
	}
	

}
