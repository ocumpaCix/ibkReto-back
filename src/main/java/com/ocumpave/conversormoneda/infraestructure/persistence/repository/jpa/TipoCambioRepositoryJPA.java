package com.ocumpave.conversormoneda.infraestructure.persistence.repository.jpa;

import com.ocumpave.conversormoneda.infraestructure.persistence.entities.TipoCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoCambioRepositoryJPA extends JpaRepository<TipoCambioEntity, Long> {
    Optional<TipoCambioEntity> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
