package com.ocumpave.conversormoneda.infraestructure.persistence.repository.impl;

import com.ocumpave.conversormoneda.infraestructure.persistence.entities.TipoCambioEntity;
import com.ocumpave.conversormoneda.infraestructure.persistence.repository.TipoCambioRepository;
import com.ocumpave.conversormoneda.infraestructure.persistence.repository.jpa.TipoCambioRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class TipoCambioRespositoryImpl implements TipoCambioRepository {
    private final TipoCambioRepositoryJPA repositoryJPA;

    @Override
    public void saveAll(Iterable<TipoCambioEntity> tiposCambio) {
        repositoryJPA.saveAll(tiposCambio);
    }

    @Override
    public List<TipoCambioEntity> listar() {
        return repositoryJPA.findAll();
    }

    @Override
    public Optional<TipoCambioEntity> find(String monedaOrigen, String monedaDestino) {
        return repositoryJPA.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);
    }

    @Override
    public void save(TipoCambioEntity tipoCambio) {
        repositoryJPA.save(tipoCambio);
    }
}
