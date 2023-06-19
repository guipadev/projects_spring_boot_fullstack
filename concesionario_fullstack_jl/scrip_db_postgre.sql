-- Crear esquema
CREATE SCHEMA IF NOT EXISTS concesionario;

-- Utilizar el esquema
SET search_path TO concesionario;

-- Crear tabla cliente
CREATE TABLE IF NOT EXISTS cliente (
  cedula INT NOT NULL,
  nombre_completo VARCHAR(255) NOT NULL,
  correo VARCHAR(255) NOT NULL,
  activo TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  numero_celular DECIMAL(19, 0) NULL,
  PRIMARY KEY (cedula)
);


-- Crear tabla marca_coche
CREATE TABLE IF NOT EXISTS marca_coche (
  id INT NOT NULL,
  descripcion VARCHAR(255) NULL,
  PRIMARY KEY (id)
);


-- Crear tabla coches
CREATE TABLE IF NOT EXISTS coches (
  codigo_coche INTEGER NOT NULL,
  marca_coche_id INT NOT NULL,
  referencia VARCHAR(255) NOT NULL,
  precio DECIMAL(10, 2) NOT NULL,
  anio_modelo DECIMAL(10, 2) NOT NULL,
  color VARCHAR(255) NOT NULL,
  numero_caballos_fuerza DECIMAL(10, 2) NULL,
  cantidad_puertas DECIMAL(10, 2) NULL,
  cilindraje DECIMAL(10, 2) NULL,
  trasmicion VARCHAR(255) NULL,
  tipo_combustible VARCHAR(255) NULL,
  cantidad_asientos DECIMAL(10, 2) NULL,
  traccion DECIMAL(10, 2) NULL,
  direccion VARCHAR(255) NULL,
  categoria VARCHAR(255) NULL,
  ruta_imagen VARCHAR(255) NULL,
  PRIMARY KEY (codigo_coche),
  FOREIGN KEY (marca_coche_id)
    REFERENCES marca_coche (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


-- Crear tabla compras
CREATE TABLE IF NOT EXISTS compras (
  numero_factura INT NOT NULL,
  cliente_cedula INT NOT NULL,
  fecha DATE NOT NULL,
  total INT NOT NULL,
  PRIMARY KEY (numero_factura),
  CONSTRAINT fk_compras_cliente
    FOREIGN KEY (cliente_cedula)
    REFERENCES cliente (cedula)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Crear tabla coches_compra
CREATE TABLE IF NOT EXISTS coches_compras (
  coches_codigo_coche INT NOT NULL,
  compras_numero_factura INT NOT NULL,
  PRIMARY KEY (coches_codigo_coche, compras_numero_factura),
  FOREIGN KEY (compras_numero_factura)
    REFERENCES compras (numero_factura)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (coches_codigo_coche)
    REFERENCES coches (codigo_coche)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
