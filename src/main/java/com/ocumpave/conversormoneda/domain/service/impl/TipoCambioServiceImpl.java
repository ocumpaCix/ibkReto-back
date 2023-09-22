package com.ocumpave.conversormoneda.domain.service.impl;

import com.ocumpave.conversormoneda.domain.service.TipoCambioService;
import com.ocumpave.conversormoneda.infraestructure.persistence.entities.TipoCambioEntity;
import com.ocumpave.conversormoneda.infraestructure.persistence.repository.TipoCambioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TipoCambioServiceImpl implements TipoCambioService {
    private final TipoCambioRepository repository;

    @Override
    public List<TipoCambioEntity> list() {
        return repository.listar();
    }

    @Override
    public Optional<TipoCambioEntity> find(String monedaOrigen, String monedaDestino) {
        return repository.find(monedaOrigen, monedaDestino);
    }

    @Override
    public void save(TipoCambioEntity tipoCambio) {
        repository.save(tipoCambio);
    }
}
