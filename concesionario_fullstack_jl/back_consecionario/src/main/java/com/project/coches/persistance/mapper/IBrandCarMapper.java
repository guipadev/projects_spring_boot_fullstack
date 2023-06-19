package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma objetos de MarcaCoche a pojos o entidades
 */
@Mapper(componentModel = "spring")
public interface IBrandCarMapper {

    /**
     * Convierte una entidad a un pojo/dto de marca coche
     * @param marcaEntity Entidad a convertir
     * @return Pojo convertido
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    BrandCarDto toMarcaCocheDto(BrandCarEntity marcaEntity);

    // Esta parte podria no ir, ya que los nombre de var son iguales
    /**
     * Los ajustes anteriores se toman en cuenta y se invierten/biceversa
     * Convierte un pojo a una entidad de marca coche
     * @param marcaDto Pojo a convertir
     * @return Entity convertido
     */
    @InheritInverseConfiguration
    BrandCarEntity toMarcaCocheEntity(BrandCarDto marcaDto);

    /**
     * Retorna una lista de marcas coches transformada a pojo/dto de una lista de entidades
     * @param marcasCocheEntity Entidad a transformar
     * @return Lista transformada
     */
    List<BrandCarDto> toMarcasCocheDto(List<BrandCarEntity> marcasCocheEntity);
}
