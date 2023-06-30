package com.poc.service.metier;

import com.poc.model.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class CustomerServiceImp implements CustomerService {

    @Override
    @Async("asyncExecutor1")
    public CompletableFuture<Customer> getCustomerByID(String id) throws InterruptedException {
        log.info("Filling the customer details for id {} ", id);
        Customer customer = new Customer();
        customer.setFirstName("Javadev");
        customer.setLastName("Journal");
        customer.setAge(34);
        customer.setEmail("contact-mg@devpoc");
        // doing an artificial sleep
        Thread.sleep(2000);
        return CompletableFuture.completedFuture(customer);
    }

    @Override
    @Async
    public void updateCustomer(Customer customer) {
        log.warn("Running method with thread {} :", Thread.currentThread().getName());
        // do nothing
    }

    @Override
    public Customer getCustomerByEmail(String email) throws InterruptedException {
        log.info("Filling the customer details for email {} : ", email);
        Customer customer = new Customer();
        customer.setFirstName("New");
        customer.setLastName("Customer");
        customer.setAge(30);
        customer.setEmail("contact-mg@devpoc");
        Thread.sleep(2000);
        return customer;
    }
}
