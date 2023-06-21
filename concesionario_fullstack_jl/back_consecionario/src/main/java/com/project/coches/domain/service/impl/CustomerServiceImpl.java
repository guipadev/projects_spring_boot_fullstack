package com.project.coches.domain.service.impl;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.domain.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de Cliente
 */
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository iCustomerRepository;
    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCustomerId(String customerId) {
        return iCustomerRepository.getCustomerByCustomerId(customerId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public CustomerDto save(CustomerDto newCustomer) {
        return iCustomerRepository.save(newCustomer);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto modifyCustomer) {

        if (iCustomerRepository.getCustomerByCustomerId(modifyCustomer.getCardId()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(iCustomerRepository.save(modifyCustomer));
    }

    @Override
    public boolean delete(String customerId) {
        if (iCustomerRepository.getCustomerByCustomerId(customerId).isEmpty()) {
            return false;
        }

        iCustomerRepository.delete(customerId);
        return true;
    }


}
