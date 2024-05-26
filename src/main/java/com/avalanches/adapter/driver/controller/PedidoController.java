package com.avalanches.adapter.driver.controller;

import com.avalanches.adapter.driver.Convert;
import com.avalanches.adapter.driver.dto.PedidoRequest;
import com.avalanches.adapter.driver.dto.PedidoResponse;
import com.avalanches.core.application.usecases.PedidoUseCasePort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avalanches/v1/pedido")
@Validated
public class PedidoController implements PedidoControllerDoc {

    @Autowired
    private PedidoUseCasePort pedidoUseCasePort;

    @PostMapping
    @Override
    public ResponseEntity<Integer> cadastrar(@Valid @RequestBody PedidoRequest pedido) {
        Integer numeroPedido = pedidoUseCasePort.cadastrar(Convert.pedidoRequestToPedido(pedido));
        return ResponseEntity.status(HttpStatus.CREATED).body(numeroPedido);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PedidoResponse>> listar() {

        List<PedidoResponse> response = Convert.pedidoToPedidoResponse(pedidoUseCasePort.listar());
        return ResponseEntity.ok().body(response);
    }

}
