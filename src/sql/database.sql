CREATE DATABASE IF NOT EXISTS pasteleria;
USE pasteleria;
CREATE TABLE usuarios (
id_user INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(200) NOT NULL,
email VARCHAR (200) NOT NULL
);

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