package net.outsila.customerservice.controllers;

import net.outsila.customerservice.CustomerService;
import net.outsila.customerservice.entities.Customer;
import net.outsila.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerservice;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerservice.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerByID(@PathVariable Long id) {
        return customerservice.findCustomerById(id);
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
      return   customerservice.saveCustomer(customer);
    }
}

