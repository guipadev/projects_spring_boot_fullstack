package co.sd.services;

import co.sd.commons.GenericService;
import co.sd.models.Persona;

/**
 * Normalmente creamos unos métodos para Crear, Guardar, Eliminar, Buscar por ID
 * Pero desde una perspectiva de escalabilidad la aplicación se tiende a ser
 * tediosa
 * Por eso es mejor crear clases genéricas, las cuales podran utilizarse en
 * cualquier servicio
 * de la aplicación ahorrandonos el escribir repetidamente métodos que son
 * prácticamente iguales
 * y solo cubren repetición de código en la aplicación
 */

public interface PersonaService extends GenericService<Persona, Long> {

}
