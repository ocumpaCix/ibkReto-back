package com.ocumpave.conversormoneda.application.service;

import com.ocumpave.conversormoneda.application.dto.request.ActualizarTasaCambioRequest;
import com.ocumpave.conversormoneda.application.dto.request.CambioMonedaRequest;
import com.ocumpave.conversormoneda.application.dto.response.AppResponse;

import javax.servlet.http.HttpServletResponse;

public interface TipoCambioExternalService {
    AppResponse listar();

    AppResponse cambiarMoneda(CambioMonedaRequest request, HttpServletResponse servletResponse);

    AppResponse actualizarTasaCambio(ActualizarTasaCambioRequest request, HttpServletResponse servletResponse);
}
