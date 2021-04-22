package entity;

public class Room {
	private int roomId;
	private String roomName;
	private int occupancy; 
	
	public Room (int roomId, String roomName, int occupancy) {
		this.setRoomId(roomId); 
		this.setRoomName(roomName); 
		this.setOccupancy(occupancy);
	}
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

}
