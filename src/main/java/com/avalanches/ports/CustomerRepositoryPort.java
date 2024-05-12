package com.avalanches.ports;

import com.avalanches.core.domain.entities.Customer;

public interface CustomerRepositoryPort {

    void insert(Customer customer);

}
