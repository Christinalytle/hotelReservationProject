create database if not exists hotel_reservation; 

use hotel_reservation; 

drop table if exists reservations; 
drop table if exists rooms; 
drop table if exists users; 


create table users (
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(25) not null, 
    last_name varchar(25) not null, 
    email varchar(100) not null,
    PRIMARY KEY (id)
);

create table rooms (
    id int NOT NULL AUTO_INCREMENT, 
    name varchar(100) not null, 
    occupancy int not null,
    PRIMARY KEY (id)
);

create table reservations (
    id int NOT NULL AUTO_INCREMENT, 
    user_id int not null, 
    room_id int not null, 
    arrival_date varchar(11) not null, 
    departure_date varchar(11) not null, 
    PRIMARY KEY (id), 
    foreign key (user_id) references users (id), 
    foreign key (room_id) references rooms (id)
);