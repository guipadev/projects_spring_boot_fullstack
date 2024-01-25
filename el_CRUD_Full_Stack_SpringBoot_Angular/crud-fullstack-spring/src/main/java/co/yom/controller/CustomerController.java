package co.yom.controller;

import co.yom.entity.Customer;
import co.yom.service.impl.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// http://localhost:8081/api/customers
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    // http://localhost:8081/api/customers
    @PostMapping
    // @RequestBody JSON -> Entity
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    // http://localhost:8081/api/customers
    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    // http://localhost:8081/api/customers/1
    @GetMapping("/{id}")
    public Customer findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    // http://localhost:8081/api/customers/1
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        customerService.deleteById(id);
    }

    // http://localhost:8081/api/customers
    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        Customer customerDb = customerService.findById(customer.getId());
        customerDb.setFirstName(customer.getFirstName());
        customerDb.setLastName(customer.getLastName());
        customerDb.setEmail(customer.getEmail());
        return customerService.update(customerDb);
    }
}
