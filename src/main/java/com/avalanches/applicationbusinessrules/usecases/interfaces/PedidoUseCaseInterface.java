package com.avalanches.applicationbusinessrules.usecases.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PedidoUseCaseInterface {
    Integer cadastrar(Pedido pedido);

    List<Pedido> listar();
}
