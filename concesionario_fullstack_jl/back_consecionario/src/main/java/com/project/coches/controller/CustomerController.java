package com.project.coches.controller;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.service.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerUseCase iCustomerUseCase;

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(iCustomerUseCase.getAll());
    }

    @GetMapping(path = "/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String customerId) {
        return ResponseEntity.of(iCustomerUseCase.getCustomerByCustomerId(customerId));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.of(iCustomerUseCase.getCustomerByEmail(email));
    }

    @PostMapping()
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDtoNew) {

       return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCustomerUseCase.save(customerDtoNew));
    }

    @PatchMapping()
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDtoUpdate) {
        return ResponseEntity.of(iCustomerUseCase.update(customerDtoUpdate));
    }

    @DeleteMapping(path = "{customerId}")
    public ResponseEntity<Boolean> delete(@PathVariable String customerId) {
        return new ResponseEntity<>(this.iCustomerUseCase.delete(customerId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
