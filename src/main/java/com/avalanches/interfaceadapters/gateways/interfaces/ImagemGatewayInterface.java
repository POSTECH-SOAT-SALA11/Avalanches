package com.avalanches.interfaceadapters.gateways.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Imagem;

public interface ImagemGatewayInterface {

    void cadastrar(Imagem imagem);

    void atualizar(Imagem imagem);

    void excluir(Imagem imagem);

    byte[] lerArquivo(String path);
}
