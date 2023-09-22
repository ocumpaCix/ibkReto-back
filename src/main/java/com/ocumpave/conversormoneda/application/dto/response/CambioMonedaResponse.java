package com.ocumpave.conversormoneda.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CambioMonedaResponse {
    BigDecimal monto;
    BigDecimal montoConvertido;
    String monedaOrigen;
    String monedaDestino;
    BigDecimal tasaCambio;
}
