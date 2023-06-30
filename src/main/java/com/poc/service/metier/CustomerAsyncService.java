package com.poc.service.metier;

import com.poc.model.domain.Customer;
import com.poc.service.businessdeleguate.CustomerBDL;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerAsyncService {

    private final CustomerBDL customerBDL;

    @Async
    public CompletableFuture<Customer> getCustomerName() throws InterruptedException {
        Customer customerName = customerBDL.getCustomerName();
        Thread.sleep(1000L);  // Intentional delay
        return CompletableFuture.completedFuture(customerName);
    }

    @Async
    public CompletableFuture<Customer> getCustomerPhoneNumber() throws InterruptedException {
        Customer customerPhone = customerBDL.getCustomerPhoneNumber();
        Thread.sleep(1000L);  // Intentional delay
        return CompletableFuture.completedFuture(customerPhone);
    }

    @Async
    public CompletableFuture<Customer> getCustomerAddress() throws InterruptedException {
        Customer customerAddress = customerBDL.getCustomerAddress();
        Thread.sleep(1000L);  // Intentional delay
        return CompletableFuture.completedFuture(customerAddress);
    }

}
