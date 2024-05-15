package com.avalanches.adapter.driver.controller;

import com.avalanches.adapter.driver.Convert;
import com.avalanches.adapter.driver.dto.ClienteRequest;
import com.avalanches.core.application.usecases.CustomerUseCasePort;
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
public class ClienteController {

    @Autowired
    private CustomerUseCasePort servicePort;

    @PostMapping("/cliente")
    public ResponseEntity<Void> create(@Valid  @RequestBody ClienteRequest cliente) {
        servicePort.insertCustomer(Convert.customerRequestToCustomer(cliente));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
