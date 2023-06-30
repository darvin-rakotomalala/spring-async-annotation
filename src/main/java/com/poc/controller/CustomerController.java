package com.poc.controller;

import com.poc.model.domain.Customer;
import com.poc.service.metier.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public CompletableFuture<Customer> getCustomerById(@PathVariable String id) throws InterruptedException {
        return customerService.getCustomerByID(id);
    }

    @PutMapping
    public void updateCustomer() {
        customerService.updateCustomer(null);
    }

    @GetMapping("/id/{email}")
    public Customer getCustomerByEmail(@PathVariable String email) throws InterruptedException {
        return customerService.getCustomerByEmail(email);
    }
}
