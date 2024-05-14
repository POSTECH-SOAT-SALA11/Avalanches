package com.avalanches.adapter.driver;

import com.avalanches.adapter.driver.dto.CustomerRequest;
import com.avalanches.core.domain.entities.Customer;

public class Convert {

    public static Customer customerRequestToCustomer(CustomerRequest request) {
        return new Customer(request.name(), request.document(), request.email());
    }
}
