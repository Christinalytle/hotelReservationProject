/* Menu:
Create Account/User
Select available rooms  
Select room
Select arrival and departure date 
Show confirmation of your reservation 
Update arrival/departure date 
Delete a reservation 
*/ 

INSERT INTO users (first_name, last_name, email) VALUES (?,?,?); 

SELECT * FROM rooms WHERE room_id NOT IN (SELECT room_id FROM reservations); 

INSERT INTO reservations (user_id, room_id, arrival_date, departure_date) VALUES (uselastid,?,?,?)

UPDATE reservations SET arrival_date = ?, departure_date =? WHERE id = ?; 

INSERT INTO rooms (name, occupancy) VALUES ("Single", 1), ("Double", 2), ("Triple", 3), ("Quad", 4), ("Queen", 2), 
("King", 2), ("Double-Double", 4), ("Studio", 5);

INSERT INTO users (first_name, last_name, email) VALUES ("Christina", "Lytle", "christina@gmail.com"); 

INSERT INTO reservations (user_id, room_id, arrival_date, departure_date) VALUES
(1, 5, "01/29/2021", "01/31/2021"); 

SELECT * FROM rooms r WHERE id NOT IN (SELECT room_id FROM reservations);

SELECT * FROM rooms r WHERE id NOT IN (SELECT room_id FROM reservations rs 
WHERE (arrival_date <= '2021-01-31' AND departure_date >= '2021-01-29'));

SELECT room_id FROM reservations rs WHERE  (arrival_date <= '2021-01-31' AND departure_date >= '2021-01-29')