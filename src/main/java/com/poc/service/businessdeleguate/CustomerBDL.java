package com.poc.service.businessdeleguate;

import com.poc.model.domain.Customer;

public interface CustomerBDL {
    Customer getCustomerName();
    Customer getCustomerPhoneNumber();
    Customer getCustomerAddress();
}
