package com.project.coches.domain.service;

import com.project.coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {

    /**
     * Devuelve na lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    List<BrandCarDto> getAll();

    /**
     * Devuelve  una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    Optional<BrandCarDto> getBrandCar(Integer id);

    /**
     * Guarda/Actualizar una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    BrandCarDto save(BrandCarDto newBrandCar);

    /**
     * Actualiza una marca coche
     * @param newBrandCar marca coche a actualizar
     * @return marca coche actualizada
     */
    Optional<BrandCarDto> update(BrandCarDto newBrandCar);

    /**
     * Elimina una marcha coche dada su id
     * @param idBrandCar Id del marca coche a eliminar
     */
    boolean delete(Integer idBrandCar);

}
