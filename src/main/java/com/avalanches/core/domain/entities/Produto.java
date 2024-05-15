package com.avalanches.core.domain.entities;

import java.math.BigDecimal;
import java.util.List;

public class Produto {

    private int id;

    private BigDecimal valor;

    private int quantidade;

    private CategoriaProduto categoria;

    private String nome;

    private String descricao;

    private List<Imagem> imagens;

}
