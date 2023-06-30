package com.poc.service.businessdeleguate;

import com.poc.model.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerBDLImpl implements CustomerBDL {

    private static final String custId = "CUST-1";

    @Override
    public Customer getCustomerName() {
        var newCustomerName = new Customer();
        newCustomerName.setId(custId);
        newCustomerName.setFirstName("Darvin");
        newCustomerName.setLastName("Tojo");
        return newCustomerName;
    }

    @Override
    public Customer getCustomerPhoneNumber() {
        var newCustomerPhone = new Customer();
        newCustomerPhone.setId(custId);
        newCustomerPhone.setPhone("+261 34 97 652 73");
        return newCustomerPhone;
    }

    @Override
    public Customer getCustomerAddress() {
        var newCustomerAddress = new Customer();
        newCustomerAddress.setId(custId);
        newCustomerAddress.setAddress("Soavimasoandro Antananarivo");
        return newCustomerAddress;
    }
}
