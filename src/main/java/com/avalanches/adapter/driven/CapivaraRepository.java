package com.avalanches.adapter.driven;

import com.avalanches.core.domain.repositories.CapivaraRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class CapivaraRepository implements CapivaraRepositoryPort {
    @Override
    public String cadastrarCapivara() {
        return "Capivara cadastrada com sucesso";
    }
}
