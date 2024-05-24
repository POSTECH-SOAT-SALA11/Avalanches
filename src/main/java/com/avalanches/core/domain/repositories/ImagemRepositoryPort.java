package com.avalanches.core.domain.repositories;
import com.avalanches.core.domain.entities.Imagem;

import java.awt.*;

public interface ImagemRepositoryPort {

    void cadastrar(Imagem imagem);

    void atualizar(Imagem imagem);

    void excluir(Imagem imagem);

    byte[] lerArquivo(String path);
}
