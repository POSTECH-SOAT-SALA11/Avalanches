package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Customer;
import com.avalanches.core.domain.utils.EncryptionUtils;
import com.avalanches.core.domain.repositories.CustomerRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class CustomerUseCase implements CustomerUseCasePort {

    @Inject
    CustomerRepositoryPort repository;

    @Override
    public void insertCustomer(Customer customer) {
        customer.setDocument(EncryptionUtils.encrypt(customer.getDocument()));
        repository.insert(customer);
    }

}
