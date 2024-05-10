package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.repositories.CapivaraRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapivaraUseCase implements CapivaraUseCasePort {

    @Autowired
    private CapivaraRepositoryPort capivaraRepositoryPort;

    @Override
    public String cadastrarCapivara() {
        return capivaraRepositoryPort.cadastrarCapivara();
    }
}
