package com.avalanches.frameworksanddrivers.api.dto;

import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Imagem;

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

