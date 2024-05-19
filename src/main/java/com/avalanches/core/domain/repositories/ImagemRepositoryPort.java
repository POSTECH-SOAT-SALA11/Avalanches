package com.avalanches.core.domain.repositories;
import com.avalanches.core.domain.entities.Imagem;

public interface ImagemRepositoryPort {

    void insert(Imagem imagem);

    void update(Imagem imagem);

}
