package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.persistance.crud.ICustomerCrudRepository;
import com.project.coches.persistance.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository

public class CustomerRepositoryImpl implements ICustomerRepository {

    private final ICustomerCrudRepository iCustomerCrudRepository;

    private final ICustomerMapper iCustomerMapper;
    @Override
    public List<CustomerDto> getAll() {
        return iCustomerMapper.toCustomersDto(iCustomerCrudRepository.findAll());
    }

    @Override
    public Optional<CustomerDto> getCustomerByCustomerId(String customerId) {
        return iCustomerCrudRepository.findById(customerId)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerCrudRepository.findByEmail(email)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto newCustomer) {
        return iCustomerMapper
                .toCustomerDto(iCustomerCrudRepository
                        .save(iCustomerMapper
                                .toCustomerEntity(newCustomer)));
    }

    @Override
    public void delete(String customerId) {
        iCustomerCrudRepository.deleteById(customerId);
    }
}
