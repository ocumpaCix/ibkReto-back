package com.ocumpave.conversormoneda.infraestructure.persistence.repository;

import com.ocumpave.conversormoneda.infraestructure.persistence.entities.TipoCambioEntity;

import java.util.List;
import java.util.Optional;

public interface TipoCambioRepository {
    void saveAll(Iterable<TipoCambioEntity> tiposCambio);

    List<TipoCambioEntity> listar();

    Optional<TipoCambioEntity> find(String monedaOrigen, String monedaDestino);

    void save(TipoCambioEntity tipoCambio);
}
