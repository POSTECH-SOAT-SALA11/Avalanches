package com.avalanches.adapter.driven.database.repository;

import com.avalanches.core.domain.entities.Customer;
import com.avalanches.core.utils.EncryptionUtils;
import com.avalanches.ports.CustomerRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements CustomerRepositoryPort {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Customer customer) {

        jdbcTemplate.update("INSERT INTO customer (id, name, document, email) VALUES (?, ?, ?, ?);",
                customer.getId(),
                customer.getName(),
                customer.getDocument(),
                customer.getEmail());
    }


}
