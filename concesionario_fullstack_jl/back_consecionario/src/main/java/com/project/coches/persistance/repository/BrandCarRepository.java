package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.repository.IBrandCarRepository;
import com.project.coches.persistance.entity.BrandCarEntity;
import com.project.coches.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Repositorio de marca coche
 */
@RequiredArgsConstructor // Crear constructor con los atributos final
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    /**
     * Crud de marca coche
     */
    private final IBrandCardCrudRepository iBrandCardCrudRepository;

    /**
     * Mapper de marca coche
     */
    private final IBrandCarMapper iBrandCarMapper;

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarMapper.toMarcasCocheDto(iBrandCardCrudRepository.findAll());
    }

    /**
     * Devuelve una marca de coche dad su Id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrada
     */
    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCardCrudRepository.findById(id)
                .map(iBrandCarMapper::toMarcaCocheDto);
        // brandCarEntity -> iBrandCarMapper.toMarcaCocheDto(brandCarEntity) LAMBDA
        // iBrandCarMapper::toMarcaCochoDto Método por REFERENCIA
    }

    /**
     * Guardar una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        BrandCarEntity brandCarEntity = iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
        return iBrandCarMapper.toMarcaCocheDto(iBrandCardCrudRepository.save(brandCarEntity));
    }

    /**
     * Eliminar una marca coche dada su Id
     * @param idBrandCar Id del marca coche a eliminar
     */
    @Override
    public void delete(Integer idBrandCar) {
        iBrandCardCrudRepository.deleteById(idBrandCar);
    }
}
