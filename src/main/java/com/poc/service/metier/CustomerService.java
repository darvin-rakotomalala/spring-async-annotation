package com.poc.service.metier;

import com.poc.model.domain.Customer;

import java.util.concurrent.CompletableFuture;

public interface CustomerService {
    CompletableFuture<Customer> getCustomerByID(String id) throws InterruptedException;
    void updateCustomer(Customer customer);
    Customer getCustomerByEmail(String email) throws InterruptedException;
}
