package com.avalanches.core.domain.repositories;

import com.avalanches.core.domain.entities.Customer;

public interface CustomerRepositoryPort {

    void insert(Customer customer);

}
