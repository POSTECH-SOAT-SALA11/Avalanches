package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Pedido;
import org.springframework.stereotype.Service;

@Service
public interface PedidoUseCasePort {
    Integer cadastrar(Pedido pedido);
}
