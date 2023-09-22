package com.ocumpave.conversormoneda.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CambioMonedaRequest {
    @NotBlank
    private String monedaOrigen;
    @NotBlank
    private String monedaDestino;
    @NotNull
    private BigDecimal monto;
}
