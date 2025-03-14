--INSERTAR ROLES SISTEMA
INSERT INTO barbershop.roles(name, created_date_time)VALUES ('ADMIN', current_timestamp);
INSERT INTO barbershop.roles(name, created_date_time)VALUES ('BARBERO', current_timestamp);
INSERT INTO barbershop.roles(name, created_date_time)VALUES ('CLIENTE', current_timestamp);

--CREAR PERSONA
INSERT INTO barbershop.person(created_date_time, role_id, email, last_name, name, phone)VALUES (current_timestamp, 1, 'kevinlazarok23@gmail.com', 'vergel', 'kevin', '123456');
INSERT INTO barbershop.person(created_date_time, role_id, email, last_name, name, phone)VALUES (current_timestamp, 2, 'ksvergel@gmail.com', 'lazaro', 'santiago', '654321');
INSERT INTO barbershop.person(created_date_time, role_id, email, last_name, name, phone)VALUES (current_timestamp, 3, 'pepito@gmail.com', 'perez', 'pepe', '112233');
INSERT INTO barbershop.person(created_date_time, role_id, email, last_name, name, phone)VALUES (current_timestamp, 3, 'aguacate@gmail.com', 'gomez', 'aguacate', '112233');

--INSERTAR USUARIOS DEL SISTEMA

INSERT INTO barbershop.users (created_date_time, person_id, password, username,active)VALUES (current_timestamp, 1, '12345', 'kevin',TRUE);
INSERT INTO barbershop.users (created_date_time, person_id, password, username,active)VALUES (current_timestamp, 2, '12345', 'santiago',TRUE);
INSERT INTO barbershop.users (created_date_time, person_id, password, username,active)VALUES (current_timestamp, 3, '12345', 'pepe',TRUE);

--INSERTAR CITAS AL SITEMA
INSERT INTO barbershop.appointment (date_time, created_date_time, date, user_id, description) VALUES ('12:00:00',current_timestamp,'2024-03-09',1,'EL MOICANO')