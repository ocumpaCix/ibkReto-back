package com.ocumpave.conversormoneda.infraestructure.init;

import com.ocumpave.conversormoneda.infraestructure.persistence.entities.TipoCambioEntity;
import com.ocumpave.conversormoneda.infraestructure.persistence.repository.TipoCambioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Component
public class InitialDataLoader implements ApplicationRunner {
    private final TipoCambioRepository tipoCambioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var tipoCambios = List.of(
                TipoCambioEntity.builder()
                        .monedaOrigen("USD")
                        .monedaDestino("PEN")
                        .tasaCambio(new BigDecimal("3.95"))
                        .build(),
                TipoCambioEntity.builder()
                        .monedaOrigen("PEN")
                        .monedaDestino("USD")
                        .tasaCambio(new BigDecimal("0.2532"))
                        .build(),
                TipoCambioEntity.builder()
                        .monedaOrigen("EUR")
                        .monedaDestino("PEN")
                        .tasaCambio(new BigDecimal("4.6621"))
                        .build(),
                TipoCambioEntity.builder()
                        .monedaOrigen("PEN")
                        .monedaDestino("EUR")
                        .tasaCambio(new BigDecimal("0.2143"))
                        .build(),
                TipoCambioEntity.builder()
                        .monedaOrigen("USD")
                        .monedaDestino("EUR")
                        .tasaCambio(new BigDecimal("0.8572"))
                        .build(),
                TipoCambioEntity.builder()
                        .monedaOrigen("EUR")
                        .monedaDestino("USD")
                        .tasaCambio(new BigDecimal("1.1665"))
                        .build()
        );
        tipoCambioRepository.saveAll(tipoCambios);
    }
}
