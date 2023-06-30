package com.poc.controller;

import com.poc.model.domain.Customer;
import com.poc.service.metier.CustomerAsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping(path = "customers")
@RequiredArgsConstructor
public class CustomerAsyncController {

    private final CustomerAsyncService customerAsyncService;

    @GetMapping(value = "/testAsync")
    public void testAsynch() throws InterruptedException, ExecutionException {
        log.info("### testAsynch Start");

        CompletableFuture<Customer> customerName = customerAsyncService.getCustomerName();
        CompletableFuture<Customer> customerPhone = customerAsyncService.getCustomerPhoneNumber();
        CompletableFuture<Customer> customerAddress = customerAsyncService.getCustomerAddress();

        // Wait until they are all done
        CompletableFuture.allOf(customerName, customerPhone, customerAddress).join();

        log.info("--- CustomerName--> " + customerName.get());
        log.info("--- CustomerPhone--> " + customerPhone.get());
        log.info("--- CustomerAddress--> " + customerAddress.get());
    }

}
