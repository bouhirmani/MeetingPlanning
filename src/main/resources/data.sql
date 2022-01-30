drop table if exists equipment; 
drop table if exists book; 
drop table if exists room; 
Create table room(
	room_name varchar(20) not null PRIMARY KEY,
	room_capacity int,
	room_last_reservation TIMESTAMP
);
Create table book(
	book_id int not null auto_increment PRIMARY KEY,
	book_date date,
	book_start_time TIMESTAMP default null,
	book_type varchar(20),
	book_nb_person int
);

Create table equipment(
	equipment_id int not null auto_increment PRIMARY KEY,
	equipment_name varchar(255),
	room_name varchar(20),
	FOREIGN KEY (room_name) REFERENCES room (room_name)
);
insert into room values('E1001','23','2022-01-29 09:00:00');
insert into room values('E1002','10','2022-01-29 09:00:00');
insert into room values('E1003','8','2022-01-29 09:00:00');
insert into room values('E1004','4','2022-01-29 09:00:00');
insert into room values('E2001','4','2022-01-29 09:00:00');
insert into room values('E2002','15','2022-01-29 09:00:00');
insert into room values('E2003','7','2022-01-29 09:00:00');
insert into room values('E2004','9','2022-01-29 09:00:00');
insert into room values('E3001','13','2022-01-29 09:00:00');
insert into room values('E3002','8','2022-01-29 09:00:00');
insert into room values('E3003','9','2022-01-29 09:00:00');
insert into room values('E3004','4','2022-01-29 09:00:00');


insert into equipment values('1','None','E1001');
insert into equipment values('2','Ecran','E1002');
insert into equipment values('3','Pieuvre','E1003');
insert into equipment values('4','Tableau','E1004');
insert into equipment values('5','None','E2001');
insert into equipment values('6','Ecran','E2002');
insert into equipment values('7','Webcam','E2002');
insert into equipment values('8','None','E2003');
insert into equipment values('9','Tableau','E2004');
insert into equipment values('10','Ecran','E3001');
insert into equipment values('11','Webcam','E3001');
insert into equipment values('12','Pieuvre','E3001');
insert into equipment values('13','None','E3002');
insert into equipment values('14','Ecran','E3003');
insert into equipment values('15','Pieuvre','E3003');
insert into equipment values('16','None','E3004');

insert into book values('1','2022-01-30','2022-01-31 09:00:00','VC',8);
insert into book values('2','2022-01-30','2022-01-30 09:00:00','VC',6);
insert into book values('3','2022-01-30','2022-01-31 11:00:00','RC',4);
insert into book values('4','2022-01-30','2022-01-31 12:00:00','RS',2);
insert into book values('5','2022-01-30','2022-01-31 12:00:00','SPEC',9);
insert into book values('6','2022-01-30','2022-01-31 09:00:00','RC',7);
insert into book values('7','2022-01-30','2022-01-31 08:00:00','VC',9);
insert into book values('8','2022-01-30','2022-01-31 08:00:00','SPEC',10);
insert into book values('9','2022-01-30','2022-01-31 09:00:00','SPEC',5);
insert into book values('10','2022-01-30','2022-01-31 09:00:00','RS',4);
insert into book values('11','2022-01-30','2022-01-31 09:00:00','RC',8);
insert into book values('12','2022-01-30','2022-01-31 11:00:00','VC',12);
insert into book values('13','2022-01-30','2022-01-31 11:00:00','SPEC',5);
insert into book values('14','2022-01-30','2022-01-31 08:00:00','VC',3);
insert into book values('15','2022-01-30','2022-01-31 08:00:00','SPEC',2);
insert into book values('16','2022-01-30','2022-01-31 08:00:00','VC',12);
insert into book values('17','2022-01-30','2022-01-31 10:00:00','VC',6);
insert into book values('18','2022-01-30','2022-01-31 11:00:00','RS',2);
insert into book values('19','2022-01-30','2022-01-31 09:00:00','RS',4);
insert into book values('20','2022-01-30','2022-01-31 09:00:00','RC',7);

