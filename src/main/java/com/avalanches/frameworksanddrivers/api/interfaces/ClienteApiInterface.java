package com.avalanches.frameworksanddrivers.api.interfaces;

import com.avalanches.frameworksanddrivers.api.dto.ClienteRequest;
import com.avalanches.frameworksanddrivers.api.dto.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClienteApiInterface {

    @Operation(summary = "Cadastro de cliente",
            description = "Endpoint utilizado para realizar o cadastro de cliente.")
    ResponseEntity<Void> cadastrar(@Valid  @RequestBody ClienteRequest cliente);

    @Operation(summary = "Identifica  cliente",
            description = "Endpoint utilizado para realizar a identificação do  cliente.")
    ResponseEntity<ClienteResponse> consultar(@Parameter(description = "CPF do cliente", required = true, in = ParameterIn.PATH, example = "12345678900") String cpf);

    @Operation(summary = "Remove cadastro de cliente",
            description = "Endpoint utilizado para realizar a remoção de cadastro do  cliente.")
    ResponseEntity<Void> excluir(@Parameter(description = "CPF do cliente", required = true, in = ParameterIn.PATH, example = "12345678900") String cpf);

}
