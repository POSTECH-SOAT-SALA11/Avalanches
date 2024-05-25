package com.avalanches.adapter.driver.controller;

import com.avalanches.adapter.driver.dto.PedidoRequest;
import com.avalanches.adapter.driver.dto.ProdutoRequest;
import com.avalanches.adapter.driver.dto.ProdutoResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PedidoControllerDoc {

     @Operation(summary = "Cadastro de pedido",
             description = "Endpoint utilizado para realizar o cadastro de pedido.")
     ResponseEntity<Integer> cadastrar(@Valid @RequestBody PedidoRequest pedido);

}
