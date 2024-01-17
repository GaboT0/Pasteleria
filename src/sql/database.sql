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

DROP TABLE pasteles;
CREATE TABLE pasteles(
id_pastel INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(200) NOT NULL,
stock INT NOT NULL 
 );
DROP TABLE pasteles;
INSERT INTO pasteles (nombre, stock) VALUES ('Pastel de chocolate 1',30);
INSERT INTO pasteles (nombre, stock) VALUES ('Pastel de chocolate 2',8);
INSERT INTO pasteles (nombre, stock) VALUES ('Pastel hojuelas',2);
INSERT INTO pasteles (nombre, stock) VALUES ('Pastel de chocolate 3',5);
INSERT INTO pasteles (nombre, stock) VALUES ('Pastel galleta',0);
INSERT INTO pasteles (nombre, stock) VALUES ('Pastel frutos rojos',30);
INSERT INTO pasteles (nombre, stock) VALUES ('Pastel fresa 1',3);
INSERT INTO pasteles (nombre, stock) VALUES ('Pastel fresa 2',10);
INSERT INTO pasteles (nombre, stock) VALUES ('Pastel de chocolate 4',20);
INSERT INTO pasteles (nombre, stock) VALUES ('Pastel helado',10);

UPDATE pasteles SET stock = '10' WHERE id_pastel = '1';
UPDATE pasteles SET stock = 3 WHERE id_pastel = 3;
SELECT * FROM pasteles;
SELECT * FROM pasteles where id_pastel = 1;



DROP TABLE carrito;
CREATE TABLE carrito (
id_carrito INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_pastel INT NOT NULL,
id_user INT NOT NULL,
cantidad INT NOT NULL,
precio INT NOT NULL,
tamanio VARCHAR(30) NOT NULL,
subtotal INT NOT NULL,
total INT NOT NULL,
nombre VARCHAR(50) NOT NULL,
calle VARCHAR(100) NOT NULL,
numExt INT NOT NULL,
numInt INT,
colonia VARCHAR(50) NOT NULL,
delegacion VARCHAR(50) NOT NULL,
cp INT NOT NULL,
metodo_pago VARCHAR(30) NOT NULL,
FOREIGN KEY(id_pastel) REFERENCES pasteles(id_pastel),
FOREIGN KEY(id_user) REFERENCES usuario(id_user)
);
INSERT INTO carrito (id_pastel,id_user,cantidad,precio,tamanio,subtotal,total,nombre,calle,numExt,numInt,colonia,delegacion,cp,metodo_pago) VALUES (1,1,2,300,'Chico',600,900,'Gabo','calle 2',321,0,'colonia 1','delegacion 1',01260,'Efectivo');
INSERT INTO carrito (id_pastel,id_user,cantidad,precio,tamanio,subtotal,total,nombre,calle,numExt,numInt,colonia,delegacion,cp,metodo_pago) VALUES (1,1,1,300,'Chico',300,900,'Gabo','calle 2',321,0,'colonia 1','delegacion 1',01260,'Efectivo');

SELECT * FROM carrito where id_user = 1;
SELECT c.id_pastel,p.nombre AS nombre_pastel,c.cantidad,c.precio,c.tamanio,c.subtotal,c.total,c.nombre,c.calle,c.numExt,c.numInt,c.colonia,c.delegacion,c.cp,c.metodo_pago FROM carrito c 
JOIN pasteles p ON (c.id_pastel = p.id_pastel) where c.id_user = 2;



SELECT c.id_carrito,c.id_pastel,c.id_user,c.cantidad,c.precio,c.tamanio,c.subtotal,p.nombre FROM carrito c 
JOIN pasteles p ON (c.id_pastel = p.id_pastel)
JOIN usuario u ON (c.id_user = u.id_user)
WHERE c.id_user = u.id_user;


DROP TABLE historial;
CREATE TABLE historial (
id_historial INT NOT NULL AUTO_INCREMENT PRIMARY KEY

);
INSERT INTO historial (id_carrito,id_user,total) VALUES (1,2,1100);
INSERT INTO historial (id_carrito,id_user,total) VALUES (1,2,600);
SELECT h.id_user,h.total,c.precio,c.cantidad,c.tamanio,c.subtotal,p.nombre,p.stock FROM historial h
JOIN carrito c ON (h.id_carrito = c.id_carrito)
JOIN pasteles p ON (c.id_pastel = p.id_pastel) where h.id_user = 1;



