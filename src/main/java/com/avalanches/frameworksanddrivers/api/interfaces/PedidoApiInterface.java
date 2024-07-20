package com.avalanches.frameworksanddrivers.api.interfaces;

import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.frameworksanddrivers.api.dto.PedidoParams;
import com.avalanches.interfaceadapters.presenters.dtos.PedidoDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface PedidoApiInterface {

    @Operation(summary = "Cadastro de pedido.",
            description = "Endpoint utilizado para realizar o cadastro de pedido, já marcando-o como recebido.")
    ResponseEntity<Integer> cadastrar(@Valid @RequestBody PedidoParams pedido);

    @Operation(summary = "Atualiza status do pedido.",
            description = "Endpoint utilizado para realizar a atualização do status do pedido.")
    ResponseEntity<Void> atualizaStatus(@PathVariable("idPedido") Integer idPedido, @RequestBody StatusPedido statusPedido);

    @Operation(summary = "Listagem de pedido.",
            description = "Endpoint utilizado para realizar a listagem dos pedidos, sem os finalizados, e ordenado pela seguinte sequência:  Pronto, Em Preparação, Recebido, e Data criação")
    ResponseEntity<List<PedidoDto>> listar();

}
