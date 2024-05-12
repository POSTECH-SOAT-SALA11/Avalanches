package com.avalanches.core.service;

import com.avalanches.core.domain.entities.Customer;
import com.avalanches.ports.CustomerRepositoryPort;
import com.avalanches.ports.CustomerServicePort;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerServicePort {

    @Inject
    CustomerRepositoryPort repository;

    @Override
    public void insertCustomer(Customer customer) {
        repository.insert(customer);
    }

}
