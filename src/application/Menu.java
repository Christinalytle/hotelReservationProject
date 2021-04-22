package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.ReservationDao;
import dao.RoomDao;
import dao.UserDao;
import entity.Room;

public class Menu {
	
	private ReservationDao reservationDao = new ReservationDao(); 
	private RoomDao roomDao = new RoomDao(); 
	private UserDao userDao = new UserDao(); 
	private Scanner scanner = new Scanner(System.in); 
	private List<String> menuOptions = Arrays.asList (
			"Create Account",
			"Check Available Rooms by Date",
			"Start Reservation",
			"Update Arrival/Departure Date",
			"Cancel Reservation", 
			"Press -1 to Quit"); 
	
	public void start() {
		String selection = " "; 
		
		do {
			printMenu(); 
			selection = scanner.nextLine(); 
			try {
				if (selection.equals("1")) {
					createAccount();	
				} else if (selection.equals("2")) {
					showRoomsByDate(); 
				} else if (selection.equals("3")) {
					startReservation(); 
				} else if (selection.equals("4")) {
					updateArrivalDepartureDate(); 
				} else if (selection.equals("5")) {
					cancelReservation(); 
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}

	private void cancelReservation() throws SQLException {  
		System.out.println("You're deleting your reservation!");
		int reservationNumber = scanIntValue("Enter your reservation number:"); 
		
		reservationDao.deleteReservation(reservationNumber); 
		System.out.println("We are sorry that you had to cancel!");
		
	}

	private void showRoomsByDate() throws SQLException { 
		String arrivalDate = scanStringValue("Enter arrival date(MM/DD/YYYY):"); 
		String departureDate = scanStringValue("Enter departure date(MM/DD/YYYY):"); 
		List<Room> rooms = roomDao.getRoomsByDate(departureDate, arrivalDate);  
		System.out.println();
		for(Room room : rooms) {
			System.out.println("Room ID " + room.getRoomId()+ ") Room Type " + room.getRoomName()+",    Occupancy " + room.getOccupancy());
		}
		
	}

	private void updateArrivalDepartureDate() throws SQLException { 
		System.out.println("You're updating your reservation arrival and departure date");
		int reservationNumber = scanIntValue("Please enter your reservation confirmation number:");
		String arrivalDate = scanStringValue("Please enter your new arrival date:"); 
		String departureDate = scanStringValue("Please enter your new departure date:"); 
		reservationDao.modifyReservationDates(reservationNumber, arrivalDate, departureDate);
		System.out.println("Your reservation has been updated! Your new arrival date is: " + arrivalDate + " and new departure date is: " + departureDate);
		
	}

	private void startReservation() throws SQLException { 
		System.out.println("Thank your for choosing Phoenix Hotel!");
		int userId = userDao.getlastrow(); 
		int roomId = scanIntValue("Enter room id number:"); 
		String arrivalDate = scanStringValue("Enter arrival date(MM/DD/YYYY):"); 
		String departureDate = scanStringValue("Enter departure date(MM/DD/YYYY):"); 
		
		reservationDao.createReservation(userId, roomId, arrivalDate, departureDate); 
		
		System.out.println("Thank you for your reservation! Your confirmation number is: " + reservationDao.getlastrow() + " \nReservation information: RoomId: " 
				+ roomId + ", Arrival Date: " + arrivalDate + ", Departure Date: " + departureDate);
		
		
	}
	
	private void createAccount()throws SQLException { 
		System.out.println("Welcome to Phoenix Hotel");
		String firstName = scanStringValue("Enter your first name:"); 
		String lastName = scanStringValue("Enter your last name:"); 
		String email = scanStringValue("Enter your email address:"); 
		
		userDao.createAccount(firstName, lastName, email); 
		
		System.out.println("Thank you for creating an account! Please see available rooms and start your reservation.");
		
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n-------------------------------");
		for (int i=0;  i < menuOptions.size(); i++) {
			System.out.println(i + 1 + ") " + menuOptions.get(i));
		}
	}
	
	private int scanIntValue(String message) {
		System.out.print(message);
		String value = scanner.nextLine(); 
		return Integer.parseInt(value); 
	}

	private String scanStringValue(String message) {
		System.out.print(message);
		return scanner.nextLine(); 
	}
}
