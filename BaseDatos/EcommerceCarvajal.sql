CREATE DATABASE ecommercecarvajal;

CREATE TABLE usuario (
    idUsuario SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT null,
    
);
-- Agregar la columna "telefono" permitiendo valores nulos
ALTER TABLE usuario
ADD COLUMN telefono VARCHAR(20);

-- Agregar la columna "direccion" permitiendo valores nulos
ALTER TABLE usuario
ADD COLUMN direccion VARCHAR(255);

-- Agregar la columna "departamento" permitiendo valores nulos
ALTER TABLE usuario
ADD COLUMN departamento VARCHAR(100);

-- Agregar la columna "provincia" permitiendo valores nulos
ALTER TABLE usuario
ADD COLUMN provincia VARCHAR(100);

-- Agregar la columna "distrito" permitiendo valores nulos
ALTER TABLE usuario
ADD COLUMN distrito VARCHAR(100);

CREATE TABLE producto(
    idProducto SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio INT,
    cantidadstock INT,
    idUsuario INT,
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
);
-- Agregar la columna "dni" permitiendo valores nulos
ALTER TABLE producto
ADD COLUMN dni VARCHAR(20);

-- Agregar la columna "estado" permitiendo valores nulos
ALTER TABLE producto
ADD COLUMN estado INT;

CREATE TABLE ListaDeDeseos (
    idListaDeDeseos SERIAL PRIMARY KEY,
    idUsuario INT,
    idProducto INT,
    FechaAgregado DATE,
    FechaEliminado DATE,
    Cantidad INT,
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario),
    FOREIGN KEY (idProducto) REFERENCES producto(idProducto)
);
CREATE TABLE HistoricoListaDeDeseos (
    idHistoricoListaDeDeseos SERIAL PRIMARY KEY,
    idUsuario INT,
    idProducto INT,
    FechaAgregado DATE,
    FechaEliminado DATE,
    Cantidad INT,
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario),
    FOREIGN KEY (idProducto) REFERENCES producto(idProducto)
);
INSERT INTO usuario (nombre) VALUES
('Daniel'),
('Brayan');

INSERT INTO producto (nombre, precio, cantidadstock, idUsuario) VALUES
('producto 1', 20000, 2, 1),
('producto 2', 10000, 5, 2);

SELECT *
FROM producto x
WHERE x.nombre LIKE CONCAT('%', '%', '%');		


