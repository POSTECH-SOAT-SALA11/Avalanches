package com.avalanches.adapter.driver.controller;

import com.avalanches.adapter.driver.Convert;
import com.avalanches.adapter.driver.dto.ClienteRequest;
import com.avalanches.adapter.driver.dto.ClienteResponse;
import com.avalanches.core.application.usecases.ClienteUseCasePort;
import com.avalanches.core.domain.entities.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avalanches/v1/cliente")
@Validated
public class ClienteController implements ClienteControllerDoc {

    @Qualifier("clienteUseCase")
    @Autowired
    private ClienteUseCasePort servicePort;

    @PostMapping
    @Override
    public ResponseEntity<Void> cadastrar(@Valid  @RequestBody ClienteRequest cliente) {
        servicePort.cadastrarCliente(Convert.clienteRequestToCliente(cliente));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{cpf}")
    @Override
    public ResponseEntity<ClienteResponse> consultar(@PathVariable("cpf") String cpf) {
        ClienteResponse response = Convert.clienteToClienteResponse(servicePort.consultar(cpf));

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{cpf}/excluir")
    @Override
    public ResponseEntity<Void> excluir(@PathVariable("cpf") String cpf) {
        servicePort.excluir(cpf);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
