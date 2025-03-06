-- Insertar roles
INSERT INTO roles (name)
VALUES ('ADMIN'),
       ('BARBERO'),
       ('CLIENTE');


-- -- Insertar personas con referencia al rol_id
-- INSERT INTO person (name, last_name, email, phone, role_id)
-- VALUES ('Juan', 'Perez', 'juan@example.com', '123456789', 2);
--
-- -- Insertar usuarios con una referencia válida a la persona creada
-- INSERT INTO users (username, password, person_id)
-- VALUES ('kevin', '1234', 1)