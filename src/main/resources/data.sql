-- INSERT INTO CITYHALL (id, name) VALUES (1, 'Barcelona');
-- INSERT INTO CITYHALL (id, name) VALUES (2, 'Wien');
-- INSERT INTO CITYHALL (id, name) VALUES (3, 'München');



insert into CITYHALL (enabled, password, username) values (true, '$2a$10$iEbfZctBohHmzVyZo69/EurN.qmXfJpUdqIzuXCh4PJqFnjyTmFVK', 'admin');
insert into CITYHALL (enabled, password, username) values (true, '$2a$10$plHpH21CFPujq15wLYNp8O9KaIIFnqskTEtowXQyAT3pGXy0XrdgK', 'barcelona');
insert into CITYHALL (enabled, password, username) values (true, '$2a$10$bMNSKgEv.ttkcPk1ZqTvMewVbHS7WJnMfizrFESj7pTxpbCqi3sEi', 'wien');
insert into CITYHALL (enabled, password, username) values (true, '$2a$10$WbdV..Wr0hHUG9wASy177e724rOnJfBMbSVliz9M7kYXFw4/wMIkS', 'münchen');

INSERT INTO CITYDISTRICT (id, name,city_hall_username) VALUES (1, 'Gràcia','barcelona');
INSERT INTO CITYDISTRICT (id, name,city_hall_username) VALUES (2, 'Eixample','barcelona');
INSERT INTO CITYDISTRICT (id, name,city_hall_username) VALUES (3, 'Währing','wien');
INSERT INTO CITYDISTRICT (id, name,city_hall_username) VALUES (4, 'Penzing','wien');
INSERT INTO CITYDISTRICT (id, name,city_hall_username) VALUES (5, 'Maxvorstadt','münchen');


insert into AUTHORITIES (authority, username) values ('ADMIN', 'ADMIN');
insert into AUTHORITIES (authority, username) values ('USER', 'barcelona');
insert into AUTHORITIES (authority, username) values ('USER', 'wien');
insert into AUTHORITIES (authority, username) values ('USER', 'münchen');