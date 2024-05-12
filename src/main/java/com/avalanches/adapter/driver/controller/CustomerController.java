package com.avalanches.adapter.driver.controller;

import com.avalanches.adapter.driver.Convert;
import com.avalanches.adapter.driver.dto.CustomerRequest;
import com.avalanches.core.domain.entities.Customer;
import com.avalanches.ports.CustomerServicePort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avalanches/v1")
@Validated
public class CustomerController {

    @Autowired
    private CustomerServicePort servicePort;

    @PostMapping("/customer")
    public ResponseEntity<Void> create(@Valid  @RequestBody CustomerRequest customer) {
        servicePort.insertCustomer(Convert.customerRequestToCustomer(customer));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
