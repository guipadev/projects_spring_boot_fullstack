-- Ejercicio: Tienda de Informática
-- Crear una base de datos llamada infotienda en donde se encuentre dos tablas: producto y fabricante

-- Modelado
-- De cada productos se solicita: codigo, nombre y precio.alter
-- Además de esto, cada producto puede realizar solo UN FABRICANTE.
-- De cada fabricantes se solicita: codigo, nombre, direccion. Puede suceder que distintos productos tengan al mismo fabricante.alter
-- Realizar el modelado de la base de datos (con las correspondientes tablas y relaciones)
-- Agregar al menso 10 registros en la tabla productos y 3 en la tabla fabricantes( se sugiere tenis, futbol y basquet)

-- Consultas SQL
-- Obtener la lista completa de todos los productos ordenados por precio (de más barato a más caro)
select * from infotienda.productos order by precio asc ;
-- Obtener la lista completa de todos los fabricantes ordenados por nombre (de forma ascendente)
select * from infotienda.fabricantes order by nombre asc ;
-- Obtener el nombre y precio de los productos que valgan más de $10.000.
select nombre, precio from infotienda.productos where precio > 10000 ;
-- Obtener el nombre y precio del producto más barato.
select nombre, precio from infotienda.productos order by precio asc limit 1 ;
select nombre, min(precio) from infotienda.productos ;
-- Consultar los 2 productos más baratos
select nombre, precio from infotienda.productos order by precio asc limit 0,2 ;

create database infotienda default character set utf8;

use infotienda;
create table fabricantes (
	codigo int auto_increment primary key, 
    nombre varchar(45),
    direccion varchar(55)
);

use infotienda;
create table productos (
	codigo int auto_increment primary key, 
    nombre varchar(45),
    precio double,
    codigo_fabrica int,
	foreign key (codigo_fabrica) references fabricantes(codigo)
);

insert into infotienda.fabricantes (codigo, nombre, direccion) values
(NULL, 'Sony', 'San Martin 1298'),
(NULL, 'Logitech', 'Jujuy 198'),
(NULL, 'Samsung', 'Catamarca 102');

select * from infotienda.fabricantes;

select * from infotienda.productos;

insert into infotienda.productos (codigo, nombre, precio, codigo_fabrica) values
(NULL, 'Mouse', '2500', '2'),
(NULL, 'Playstation', '289000', '3'),
(NULL, 'S20 FE', '9000', '1'),
(NULL, 'A03 Plus', '25000', '1'),
(NULL, 'Teclado Oferta RGB', '8500', '2'),
(NULL, 'Auriculares Bluetooth', '5000', '3'),
(NULL, 'Cargador Samsung Carga Rápida', '9999', '1'),
(NULL, 'Notebook Vaio', '500000', '3'),
(NULL, 'Auriculares Gamer RGB +', '2300', '2'),
(NULL, 'Monitor 24" XLASKDJ', '35000', '1'),
(NULL, 'Webcam Clásica', '5600', '2');

