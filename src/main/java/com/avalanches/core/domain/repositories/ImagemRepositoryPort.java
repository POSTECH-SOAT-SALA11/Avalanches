package com.avalanches.core.domain.repositories;
import com.avalanches.core.domain.entities.Imagem;

import java.awt.*;

public interface ImagemRepositoryPort {

    void insert(Imagem imagem);

    void update(Imagem imagem);

    void delete(Imagem imagem);

    byte[] readFile(String path);
}
