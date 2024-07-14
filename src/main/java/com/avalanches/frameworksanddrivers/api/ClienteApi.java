package com.avalanches.frameworksanddrivers.api;

import com.avalanches.frameworksanddrivers.api.dto.ClienteRequest;
import com.avalanches.frameworksanddrivers.api.dto.ClienteResponse;
import com.avalanches.frameworksanddrivers.api.interfaces.ClienteApiInterface;
import com.avalanches.interfaceadapters.controllers.ClienteController;
import com.avalanches.interfaceadapters.controllers.interfaces.ClienteControllerInterface;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avalanches/v1/cliente")
@Validated
public class ClienteApi implements ClienteApiInterface {

    @Inject
    private JdbcOperations jdbcOperations;

    @PostMapping
    @Override
    public ResponseEntity<Void> cadastrar(@Valid  @RequestBody ClienteRequest cliente) {
        ClienteControllerInterface clienteController = new ClienteController();
        clienteController.cadastrar(Convert.clienteRequestToCliente(cliente), jdbcOperations);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{cpf}")
    @Override
    public ResponseEntity<ClienteResponse> consultar(@PathVariable("cpf") String cpf) {
        ClienteControllerInterface clienteController = new ClienteController();
        ClienteResponse response = Convert.clienteToClienteResponse(clienteController.consultar(cpf, jdbcOperations));

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{cpf}/excluir")
    @Override
    public ResponseEntity<Void> excluir(@PathVariable("cpf") String cpf) {
        ClienteControllerInterface clienteController = new ClienteController();
        clienteController.excluir(cpf, jdbcOperations);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
