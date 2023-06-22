package com.project.coches.domain.service;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.domain.service.useCase.ICustomerUseCase;
import com.project.coches.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de Cliente
 */
@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {

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
    public ResponseCustomerDto save(CustomerDto newCustomer) {

        // Expresión regular para validar el formato del correo electrónico
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (!newCustomer.getEmail().matches(emailRegex)) {
            throw new EmailValidationException();
        }

        String passwordGenerated = generateRandomPassword(8);

        newCustomer.setPassword(passwordGenerated);
        newCustomer.setActive(1);
        iCustomerRepository.save(newCustomer);

        return new ResponseCustomerDto(passwordGenerated);
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

    // Método genera contraseña aleatoria alfanumerica de una longitud especificada
    private String generateRandomPassword(int longitud) {

        // Rango ASCII - Alfanumerico (0-9, a-z, A-Z)
        final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        // Cada iteración elige aleatoriamente un caracter del rango ASCII y lo agrega a la instancia 'StringBuilder'
        for (int i = 0; i < longitud; i++){
            int randomIndex = random.nextInt(caracteres.length());
            stringBuilder.append(caracteres.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }

}
