package com.ocumpave.conversormoneda.application.service.impl;

import com.ocumpave.conversormoneda.application.dto.request.ActualizarTasaCambioRequest;
import com.ocumpave.conversormoneda.application.dto.request.CambioMonedaRequest;
import com.ocumpave.conversormoneda.application.dto.response.CambioMonedaResponse;
import com.ocumpave.conversormoneda.application.service.TipoCambioExternalService;
import com.ocumpave.conversormoneda.application.dto.response.AppResponse;
import com.ocumpave.conversormoneda.domain.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Service
public class TipoCambioExternalServiceImpl implements TipoCambioExternalService {
    private final TipoCambioService service;

    @Override
    public AppResponse listar() {
        return AppResponse.successResponse(service.list());
    }

    @Override
    public AppResponse cambiarMoneda(CambioMonedaRequest request, HttpServletResponse servletResponse) {
        var optTipoCambio = service.find(request.getMonedaOrigen(), request.getMonedaDestino());
        if (optTipoCambio.isPresent()) {
            var tipoCambio = optTipoCambio.get();
            var montoConvertido = request.getMonto().multiply(tipoCambio.getTasaCambio());
            return AppResponse.successResponse(CambioMonedaResponse.builder()
                    .monedaOrigen(tipoCambio.getMonedaOrigen())
                    .monedaDestino(request.getMonedaDestino())
                    .monto(request.getMonto())
                    .montoConvertido(montoConvertido)
                    .tasaCambio(tipoCambio.getTasaCambio())
                    .build());

        } else {
            servletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return AppResponse.builder()
                    .success(false)
                    .message("Tipo de cambio no encontrado")
                    .build();
        }

    }

    @Override
    public AppResponse actualizarTasaCambio(ActualizarTasaCambioRequest request, HttpServletResponse servletResponse) {
        var optTipoCambio = service.find(request.getMonedaOrigen(), request.getMonedaDestino());
        if (optTipoCambio.isPresent()) {
            var tipoCambio = optTipoCambio.get();
            tipoCambio.setTasaCambio(request.getTasaCambio());
            service.save(tipoCambio);
            return AppResponse.builder()
                    .success(false)
                    .message("Tasa de cambio actualizada correctamente")
                    .build();
        } else {
            servletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return AppResponse.builder()
                    .success(false)
                    .message("Tipo de cambio no encontrado")
                    .build();
        }
    }
}
