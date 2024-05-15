package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface CustomerUseCasePort {

    void insertCustomer(Cliente cliente);
}
