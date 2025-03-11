-- Insertar roles
INSERT INTO barbershop.roles (name, description, created_date_time)VALUES ('ADMIN', 'El mas grande de los grandes', current_timestamp);
INSERT INTO barbershop.roles (name, description, created_date_time)VALUES ('BARBERO', 'El chambeador', current_timestamp);
INSERT INTO barbershop.roles (name, description, created_date_time)VALUES ('CLIENTE', 'El cliente crack', current_timestamp);

-- Insertar personas con referencia al rol_id
INSERT INTO barbershop.person (name, last_name, email, phone, created_date_time)VALUES ('Kevin', 'Lázaro', 'kevinlazarok23@gmail.com', '3212766394', current_timestamp);
INSERT INTO barbershop.person (name, last_name, email, phone, created_date_time)VALUES ('Santiago', 'Vergel', 'santiago@gmail.com', '3200023212', current_timestamp);
INSERT INTO barbershop.person (name, last_name, email, phone, created_date_time)VALUES ('Pepito', 'Vergel', 'pepe@gmail.com', '3180232332', current_timestamp);

-- -- Insertar usuarios con una referencia válida a la persona creada
INSERT INTO barbershop.users (user_name, password, person_id,role_id,created_date_time)VALUES ('kevin', '12345', 1,1,current_timestamp);
INSERT INTO barbershop.users (user_name, password, person_id,role_id,created_date_time)VALUES ('santi', '12345', 2,2,current_timestamp);
INSERT INTO barbershop.users (user_name, password, person_id,role_id,created_date_time)VALUES ('pepe', '12345', 3,3,current_timestamp);