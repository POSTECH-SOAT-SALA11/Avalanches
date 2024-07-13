package com.avalanches.frameworksanddrivers.api.interfaces;

import com.avalanches.frameworksanddrivers.api.dto.PedidoRequest;
import com.avalanches.frameworksanddrivers.api.dto.PedidoResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface PedidoApiInterface {

    @Operation(summary = "Cadastro de pedido",
            description = "Endpoint utilizado para realizar o cadastro de pedido.")
    ResponseEntity<Integer> cadastrar(@Valid @RequestBody PedidoRequest pedido);

    @Operation(summary = "Listagem  de pedido",
            description = "Endpoint utilizado para realizar a listagem de todos os pedidios")
    ResponseEntity<List<PedidoResponse>> listar();

}
