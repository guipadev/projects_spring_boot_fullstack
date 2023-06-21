package com.project.coches.domain.service.impl;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.repository.IBrandCarRepository;
import com.project.coches.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de marca coche
 */
@RequiredArgsConstructor
@Service
public class BrandCarServiceImpl implements IBrandCarService {

    /**
     * Repositorio de marca coche
     */
    private final IBrandCarRepository iBrandCarRepository;


    /**
     * Devuelve na lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarRepository.getAll();
    }

    /**
     * Devuelve  una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    /**
     * Guarda/Actualizar una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }

    /**
     * Actualiza una marca coche
     * @param newBrandCar marca coche a actualizar
     * @return Optional con marca coche actualizada
     */
    @Override
    public Optional<BrandCarDto> update(BrandCarDto newBrandCar) {
        if(iBrandCarRepository.getBrandCar(newBrandCar.getId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iBrandCarRepository.save(newBrandCar));
    }

    /**
     * Elimina una marcha coche dada su id
     * @param idBrandCar Id del marca coche a eliminar
     * @Return true si se elimino, false de lo contrario
     */
    @Override
    public boolean delete(Integer idBrandCar) {

        if (iBrandCarRepository.getBrandCar(idBrandCar).isEmpty()) {
            return false;
        }

        iBrandCarRepository.delete(idBrandCar);
        return true;

    }
}
