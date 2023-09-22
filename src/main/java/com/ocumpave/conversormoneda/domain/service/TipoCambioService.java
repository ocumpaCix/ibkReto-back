package com.ocumpave.conversormoneda.domain.service;

import com.ocumpave.conversormoneda.infraestructure.persistence.entities.TipoCambioEntity;

import java.util.List;
import java.util.Optional;

public interface TipoCambioService {
    List<TipoCambioEntity> list();

    Optional<TipoCambioEntity> find(String monedaOrigen,String monedaDestino);

    void save(TipoCambioEntity tipoCambio);
}
