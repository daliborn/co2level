insert into CITYHALL (enabled, password, username) values (true, '$2a$10$ngratBBy3KyojlakgaRbrumeKqXqYy5Vpg1fcXELvPIPGSyM5zOqq', 'admin');
insert into CITYHALL (enabled, password, username) values (true, '$2a$10$plHpH21CFPujq15wLYNp8O9KaIIFnqskTEtowXQyAT3pGXy0XrdgK', 'barcelona');
insert into CITYHALL (enabled, password, username) values (true, '$2a$10$bMNSKgEv.ttkcPk1ZqTvMewVbHS7WJnMfizrFESj7pTxpbCqi3sEi', 'wien');
insert into CITYHALL (enabled, password, username) values (true, '$2a$10$WbdV..Wr0hHUG9wASy177e724rOnJfBMbSVliz9M7kYXFw4/wMIkS', 'münchen');

INSERT INTO CITYDISTRICT (id, name,city_hall_username) VALUES (1, 'Gràcia','barcelona');
INSERT INTO CITYDISTRICT (id, name,city_hall_username) VALUES (2, 'Eixample','barcelona');
INSERT INTO CITYDISTRICT (id, name,city_hall_username) VALUES (3, 'Währing','wien');
INSERT INTO CITYDISTRICT (id, name,city_hall_username) VALUES (4, 'Penzing','wien');
INSERT INTO CITYDISTRICT (id, name,city_hall_username) VALUES (5, 'Maxvorstadt','münchen');

INSERT INTO CITYHALL_CITY_DISTRICTS (city_hall_username,city_districts_id) VALUES ('barcelona',1);
INSERT INTO CITYHALL_CITY_DISTRICTS (city_hall_username,city_districts_id) VALUES ('barcelona',2);
INSERT INTO CITYHALL_CITY_DISTRICTS (city_hall_username,city_districts_id) VALUES ('wien',3);
INSERT INTO CITYHALL_CITY_DISTRICTS (city_hall_username,city_districts_id) VALUES ('wien',4);
INSERT INTO CITYHALL_CITY_DISTRICTS (city_hall_username,city_districts_id) VALUES ('münchen',5);

insert into AUTHORITIES (authority, username) values ('ADMIN', 'ADMIN');
insert into AUTHORITIES (authority, username) values ('USER', 'barcelona');
insert into AUTHORITIES (authority, username) values ('USER', 'wien');
insert into AUTHORITIES (authority, username) values ('USER', 'münchen');