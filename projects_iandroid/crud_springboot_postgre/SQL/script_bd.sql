-- CREAR BD
CREATE DATABASE persona_db;

-- CONSULTAR DATOS DE TABLA PAIS
SELECT * FROM public.pais
ORDER BY id ASC 

-- CONSULTAR TABLA ESTADO
SELECT * FROM public.estado
ORDER BY id ASC 

-- INSERTAR DATOS PERSONA
INSERT INTO public.persona(id, apellido, edad, nombre_completo, estado_id, pais_id) VALUES (0, 'Vera', 30, 'Lucho', 1, 1);

-- Filtros para la tabla `estado`
ALTER TABLE `estado`
  ADD CONSTRAINT `FK_4786469191104EC2` FOREIGN KEY (`ubicacionpaisid`) REFERENCES `ubicacionpais` (`id`);


-- CREAR TABLA NO NECESARIO
CREATE TABLE IF NOT EXISTS pais (
  id int(11) NOT NULL AUTO_INCREMENT,
  paisnombre varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=247 ;

-- CREAR TABLA ESTADO NO NECESARIO
CREATE TABLE IF NOT EXISTS estado (
  id int(11) NOT NULL AUTO_INCREMENT,
  ubicacionpaisid int(11) DEFAULT NULL,
  estadonombre varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (id),
  KEY `IDX_4786469191104EC2` (ubicacionpaisid)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2202 ;

