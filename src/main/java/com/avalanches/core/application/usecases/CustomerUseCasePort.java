package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerUseCasePort {

    void insertCustomer(Customer customer);
}
