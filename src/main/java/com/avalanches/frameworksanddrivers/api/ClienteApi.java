package com.avalanches.frameworksanddrivers.api;

import com.avalanches.applicationbusinessrules.usecases.interfaces.ClienteUseCaseInterface;
import com.avalanches.frameworksanddrivers.api.dto.ClienteRequest;
import com.avalanches.frameworksanddrivers.api.dto.ClienteResponse;
import com.avalanches.frameworksanddrivers.api.interfaces.ClienteApiInterface;
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
public class ClienteApi implements ClienteApiInterface {

    @Qualifier("clienteUseCase")
    @Autowired
    private ClienteUseCaseInterface serviceInterface;

    @PostMapping
    @Override
    public ResponseEntity<Void> cadastrar(@Valid  @RequestBody ClienteRequest cliente) {
        serviceInterface.cadastrarCliente(Convert.clienteRequestToCliente(cliente));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{cpf}")
    @Override
    public ResponseEntity<ClienteResponse> consultar(@PathVariable("cpf") String cpf) {
        ClienteResponse response = Convert.clienteToClienteResponse(serviceInterface.consultar(cpf));

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{cpf}/excluir")
    @Override
    public ResponseEntity<Void> excluir(@PathVariable("cpf") String cpf) {
        serviceInterface.excluir(cpf);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
