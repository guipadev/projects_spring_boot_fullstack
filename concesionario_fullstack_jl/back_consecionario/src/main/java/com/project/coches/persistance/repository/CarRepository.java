package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.repository.ICarRepository;

import java.util.List;
import java.util.Optional;

public class CarRepository implements ICarRepository {
    @Override
    public List<CarDto> getAll() {
        return null;
    }

    @Override
    public List<CarDto> getByIdCar(Integer idCar) {
        return null;
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return null;
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
        return Optional.empty();
    }

    @Override
    public CarDto save(CarDto newCar) {
        return null;
    }

    @Override
    public void delete(Integer idCar) {

    }
}
