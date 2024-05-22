package com.avalanches.adapter.driver.dto;

import com.avalanches.core.domain.entities.CategoriaProduto;
import com.avalanches.core.domain.entities.Imagem;

import java.math.BigDecimal;
import java.util.List;

public record ProdutoResponse(
    int id,
    BigDecimal valor,
    int quantidade,
    CategoriaProduto categoria,
    String nome,
    String descricao,
    List<Imagem> imagens
){
}

