package com.avalanches.frameworksanddrivers.api;

import com.avalanches.applicationbusinessrules.usecases.interfaces.PedidoUseCaseInterface;
import com.avalanches.frameworksanddrivers.api.interfaces.PedidoApiInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.avalanches.frameworksanddrivers.api.dto.PedidoResponse;
import com.avalanches.frameworksanddrivers.api.dto.PedidoRequest;

import java.util.List;

@RestController
@RequestMapping("/avalanches/v1/pedido")
@Validated
public class PedidoApi implements PedidoApiInterface {

    @Autowired
    private PedidoUseCaseInterface pedidoUseCaseInterface;

    @PostMapping
    @Override
    public ResponseEntity<Integer> cadastrar(@Valid @RequestBody PedidoRequest pedido) {
        Integer numeroPedido = pedidoUseCaseInterface.cadastrar(Convert.pedidoRequestToPedido(pedido));
        return ResponseEntity.status(HttpStatus.CREATED).body(numeroPedido);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PedidoResponse>> listar() {

        List<PedidoResponse> response = Convert.pedidoToPedidoResponse(pedidoUseCaseInterface.listar());
        return ResponseEntity.ok().body(response);
    }

}
