CREATE SCHEMA IF NOT EXISTS `concesionario` DEFAULT CHARACTER SET utf8 ;
USE `concesionario` ;

-- -----------------------------------------------------
-- Table `concesionario`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionario`.`cliente` (
  `cedula` INT NOT NULL,
  `nombre_completo` VARCHAR(255) NOT NULL,
  `correo` VARCHAR(255) NOT NULL,
  `activo` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cedula`)
) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionario`.`marca_coche`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionario`.`marca_coche` (
  `id` INT NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionario`.`coches`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionario`.`coches` (
  `serial_chasis` VARCHAR(255) NOT NULL,
  `marca_coche_id` INT NOT NULL,
  `referencia` VARCHAR(255) NOT NULL,
  `precio` INT NOT NULL,
  `anio_modelo` INT NOT NULL,
  `color` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`serial_chasis`),
  INDEX `fk_coches_marca_coche1_idx` (`marca_coche_id` ASC) VISIBLE,
  CONSTRAINT `fk_coches_marca_coche1`
    FOREIGN KEY (`marca_coche_id`)
    REFERENCES `concesionario`.`marca_coche` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionario`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionario`.`compras` (
  `numero_factura` INT NOT NULL,
  `clientecedula` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `total` INT NOT NULL,
  PRIMARY KEY (`numero_factura`),
  INDEX `fk_compras_cliente_idx` (`clientecedula` ASC) VISIBLE,
  CONSTRAINT `fk_compras_cliente`
    FOREIGN KEY (`clientecedula`)
    REFERENCES `concesionario`.`cliente` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionario`.`coches_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionario`.`coches_compra` (
  `cochesserial_chasis` VARCHAR(255) NOT NULL,
  `comprasnumero_factura` INT NOT NULL,
  INDEX `comprasnumero_factura_idx` (`comprasnumero_factura` ASC) VISIBLE,
  CONSTRAINT `fk_coches_compra_compras`
    FOREIGN KEY (`comprasnumero_factura`)
    REFERENCES `concesionario`.`compras` (`numero_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_coches_compra_coches`
    FOREIGN KEY (`cochesserial_chasis`)
    REFERENCES `concesionario`.`coches` (`serial_chasis`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Cambiar el nombre del campo de la tabla coche
-- -----------------------------------------------------
ALTER TABLE `concesionario`.`coches` CHANGE COLUMN `serial_chasis` `codigo_coche` VARCHAR(255) NOT NULL;


ALTER TABLE `concesionario`.`compras` 
DROP FOREIGN KEY `fk_compras_cliente`;
ALTER TABLE `concesionario`.`compras` 
CHANGE COLUMN `clientecedula` `cliente_cedula` INT NOT NULL ;
ALTER TABLE `concesionario`.`compras` 
ADD CONSTRAINT `fk_compras_cliente`
  FOREIGN KEY (`cliente_cedula`)
  REFERENCES `concesionario`.`cliente` (`cedula`);


-- -----------------------------------------------------
-- tabla coche - agregar campos y modificar tipo campo
-- -----------------------------------------------------

ALTER TABLE `concesionario`.`coches` 
ADD COLUMN `numero_caballos_fuerza` DECIMAL(10,2) NULL AFTER `color`,
ADD COLUMN `cantidad_puertas` DECIMAL(10,2) NULL AFTER `numero_caballos_fuerza`,
ADD COLUMN `cilindraje` DECIMAL(10,2) NULL AFTER `cantidad_puertas`,
ADD COLUMN `trasmicion` VARCHAR(255) NULL AFTER `cilindraje`,
ADD COLUMN `tipo_combustible` VARCHAR(255) NULL COMMENT '\n' AFTER `trasmicion`,
ADD COLUMN `cantidad_asientos` DECIMAL(10,2) NULL AFTER `tipo_combustible`,
ADD COLUMN `traccion` DECIMAL(10,2) NULL AFTER `cantidad_asientos`,
ADD COLUMN `direccion` VARCHAR(255) NULL AFTER `traccion`,
ADD COLUMN `categoria` VARCHAR(255) NULL AFTER `direccion`,
CHANGE COLUMN `precio` `precio` DECIMAL(10,2) NOT NULL ,
CHANGE COLUMN `anio_modelo` `anio_modelo` DECIMAL(10,2) NOT NULL ;

-- -----------------------------------------------------
-- tabla cliente - agregar campos y modificar tipo campo
-- -----------------------------------------------------

ALTER TABLE `concesionario`.`cliente` 
ADD COLUMN `numero_celular` DECIMAL(19,0) NULL AFTER `activo`,
CHANGE COLUMN `activo` `activo` TINYINT(1) NULL DEFAULT 0;










