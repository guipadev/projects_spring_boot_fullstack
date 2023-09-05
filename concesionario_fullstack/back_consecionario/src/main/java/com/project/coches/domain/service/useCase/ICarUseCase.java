package com.project.coches.domain.service.useCase;

import com.project.coches.domain.dto.CarDto;
import java.util.List;
import java.util.Optional;

public interface ICarUseCase {

    /**
     * Devuelve na lista con todos los clientes
     * @return Lista con clientes
     */
    List<CarDto> getAll();

    /**
     * Devuelve lista coches con ID
     * @return Lista con coches
     */
    List<CarDto> getByIdCar(Integer idCar);


    /**
     * Devuelve lista coches de acuerdo a precio
     * @return Lista con coches por precio
     */
    List<CarDto> getCarsByPriceLessThan(Double price);

    /**
     * Devuelve  un coche dado su id
     * @param idCar Id de coche
     * @return Optional del coche encontrado
     */
    Optional<CarDto> getCar(Integer idCar);


    /**
     * Guarda/Actualizar un coche
     * @param newCar coche a guardar
     * @return coche guardado
     */
    CarDto save(CarDto newCar);


    /**
     * Elimina un coche dado su id
     * @param idCar Id del coche a eliminar
     */
    boolean delete(Integer idCar);
}
