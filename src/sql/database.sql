CREATE DATABASE IF NOT EXISTS pasteleria;
USE pasteleria;

CREATE TABLE usuario (
id_user INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(200) NOT NULL,
email VARCHAR (200) NOT NULL,
contrasena VARCHAR (30) NOT NULL
);
DROP TABLE USUARIO;
SELECT * FROM usuario;
SELECT * FROM usuario WHERE (NOMBRE = 'GABO123' OR EMAIL = 'GABO123') AND CONTRASENA = '1234';
INSERT INTO USUARIO (nombre, email, contrasena) VALUES ('Gabo','gabo@gmail.com','1234');
 CREATE TABLE pasteles(
id_pastel INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(200) NOT NULL,
precio INT NOT NULL 
 );
 DROP TABLE pasteles;
INSERT INTO pasteles (nombre, precio) VALUES ('Pastel de chocolate 1',300);
INSERT INTO pasteles (nombre, precio) VALUES ('Pastel de chocolate 2',300);
INSERT INTO pasteles (nombre, precio) VALUES ('Pastel hojuelas',300);
INSERT INTO pasteles (nombre, precio) VALUES ('Pastel de chocolate 3',300);
INSERT INTO pasteles (nombre, precio) VALUES ('Pastel galleta',300);
INSERT INTO pasteles (nombre, precio) VALUES ('Pastel frutos rojos',300);
INSERT INTO pasteles (nombre, precio) VALUES ('Pastel fresa 1',300);
INSERT INTO pasteles (nombre, precio) VALUES ('Pastel fresa 2',300);
INSERT INTO pasteles (nombre, precio) VALUES ('Pastel de chocolate 4',300);
INSERT INTO pasteles (nombre, precio) VALUES ('Pastel helado',300);
SELECT * FROM pasteles;
SELECT * FROM pasteles where id_pastel = 1;



-- CREATE TABLE carrito (
-- id_carrito INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
-- id_pastel INT NOT NULL,
-- id_user INT NOT NULL,
-- total INT NOT NULL,
-- FOREIGN KEY(id_pastel) REFERENCES pasteles(id_user),
-- FOREIGN KEY(id_user) REFERENCES usuarios(id_pastel)
-- );