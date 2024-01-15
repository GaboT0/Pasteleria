CREATE DATABASE IF NOT EXISTS pasteleria;
USE pasteleria;
DROP TABLE USUARIO;
CREATE TABLE usuario (
id_user INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(200) NOT NULL,
email VARCHAR (200) NOT NULL,
contrasena VARCHAR (30) NOT NULL
);
SELECT * FROM usuario;
SELECT * FROM usuario WHERE (NOMBRE = 'GABO123' OR EMAIL = 'GABO123') AND CONTRASENA = '1234';
INSERT INTO USUARIO (nombre, email, contrasena) VALUES ('Gabo','gabo@gmail.com','1234');
-- CREATE TABLE pasteles(

-- );

-- CREATE TABLE carrito (
-- id_carrito INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
-- id_pastel INT NOT NULL,
-- id_user INT NOT NULL,
-- total INT NOT NULL,
-- FOREIGN KEY(id_pastel) REFERENCES pasteles(id_user),
-- FOREIGN KEY(id_user) REFERENCES usuarios(id_pastel)
-- );