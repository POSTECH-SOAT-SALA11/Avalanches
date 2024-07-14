package com.avalanches.frameworksanddrivers.api;

import com.avalanches.frameworksanddrivers.api.interfaces.PedidoApiInterface;
import com.avalanches.interfaceadapters.controllers.interfaces.PedidoControllerInterface;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.avalanches.frameworksanddrivers.api.dto.PedidoResponse;
import com.avalanches.frameworksanddrivers.api.dto.PedidoRequest;

import java.util.List;

@RestController
@RequestMapping("/avalanches/v1/pedido")
@Validated
public class PedidoApi implements PedidoApiInterface {

    @Qualifier("pedidoController")
    @Autowired
    private PedidoControllerInterface pedidoController;

    @Inject
    private JdbcOperations jdbcOperations;

    @PostMapping
    @Override
    public ResponseEntity<Integer> cadastrar(@Valid @RequestBody PedidoRequest pedido) {
        Integer numeroPedido = pedidoController.cadastrar(Convert.pedidoRequestToPedido(pedido), jdbcOperations);
        return ResponseEntity.status(HttpStatus.CREATED).body(numeroPedido);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PedidoResponse>> listar() {

        List<PedidoResponse> response = Convert.pedidoToPedidoResponse(pedidoController.listar(jdbcOperations));
        return ResponseEntity.ok().body(response);
    }

}
