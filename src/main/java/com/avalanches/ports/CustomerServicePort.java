package com.avalanches.ports;

import com.avalanches.core.domain.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerServicePort {

    void insertCustomer(Customer customer);
}
