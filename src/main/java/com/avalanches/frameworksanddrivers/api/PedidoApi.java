package com.avalanches.frameworksanddrivers.api;

import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.frameworksanddrivers.api.dto.WebHookMockParams;
import com.avalanches.frameworksanddrivers.api.interfaces.PedidoApiInterface;
import com.avalanches.interfaceadapters.controllers.PedidoController;
import com.avalanches.interfaceadapters.controllers.interfaces.PedidoControllerInterface;
import com.avalanches.interfaceadapters.presenters.dtos.PedidoDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.avalanches.frameworksanddrivers.api.dto.PedidoParams;

import java.util.List;

@RestController
@RequestMapping("/avalanches/v1/pedido")
@Validated
public class PedidoApi implements PedidoApiInterface {

    @Inject
    private JdbcOperations jdbcOperations;

    @PostMapping
    @Override
    public ResponseEntity<Integer> cadastrar(@Valid @RequestBody PedidoParams pedido) {
        PedidoControllerInterface pedidoController = new PedidoController();
        WebHookMockParams webHookMockParams = new WebHookMockParams();
        Integer numeroPedido = pedidoController.cadastrar(Convert.pedidoParamsToPedido(pedido), jdbcOperations, webHookMockParams);
        return ResponseEntity.status(HttpStatus.CREATED).body(numeroPedido);
    }

    @PutMapping("/{idPedido}")
    @Override
    public ResponseEntity<Void> atualizaStatus(@PathVariable("idPedido") Integer idPedido, @RequestBody StatusPedido statusPedido) {
        PedidoControllerInterface pedidoController = new PedidoController();
        pedidoController.atualizaStatus(idPedido, statusPedido, jdbcOperations);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PedidoDto>> listar() {
        PedidoControllerInterface pedidoController = new PedidoController();
        List<PedidoDto> response = pedidoController.listar(jdbcOperations);
        return ResponseEntity.ok().body(response);
    }

}
