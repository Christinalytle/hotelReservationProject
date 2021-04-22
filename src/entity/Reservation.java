package entity;

public class Reservation {
	
	private int id;
	private int userId; 
	private int roomId; 
	private String arrivalDate; 
	private String departureDate; 
	
	
	public Reservation (int id, int userId, int roomId, String arrivalDate, String departureDate) {
		this.setId(id);
		this.setUserId(userId);
		this.setRoomId(roomId);
		this.setArrivalDate(arrivalDate);
		this.setDepartureDate(departureDate);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getRoomId() {
		return roomId;
	}


	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}


	public String getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public String getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	

}
