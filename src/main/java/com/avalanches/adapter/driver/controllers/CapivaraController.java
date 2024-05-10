package com.avalanches.adapter.driver.controllers;

import com.avalanches.core.application.usecases.CapivaraUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avalanches")
public class CapivaraController{


    @Autowired
    private CapivaraUseCasePort capivaraUseCasePort;

    @GetMapping("/testes")
    public ResponseEntity<String> teste() {

        return ResponseEntity.ok().body(capivaraUseCasePort.cadastrarCapivara());
    }
}
