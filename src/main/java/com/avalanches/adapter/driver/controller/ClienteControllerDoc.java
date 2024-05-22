package com.avalanches.adapter.driver.controller;

import com.avalanches.adapter.driver.dto.ClienteRequest;
import com.avalanches.adapter.driver.dto.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClienteControllerDoc {


     @Operation(summary = "Cadastro de cliente",
             description = "Endpoint utilizado para realizar o cadastro de cliente.")
     ResponseEntity<Void> create(@Valid  @RequestBody ClienteRequest cliente);

     @Operation(summary = "Identifica  cliente",
             description = "Endpoint utilizado para realizar a identificação do  cliente.")
     ResponseEntity<ClienteResponse> identifica(@Parameter(description = "CPF do cliente", required = true, in = ParameterIn.PATH, example = "12345678900") String cpf);

     @Operation(summary = "Remove cadastro do cliente",
             description = "Endpoint utilizado para realizar a remoção de cadastro do  cliente.")
     ResponseEntity<Void> delete(@Parameter(description = "CPF do cliente", required = true, in = ParameterIn.PATH, example = "12345678900") String cpf);
}
