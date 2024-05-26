package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Pedido;
import com.avalanches.core.domain.entities.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PedidoUseCasePort {
    Integer cadastrar(Pedido pedido);

    List<Pedido> listar();
}
