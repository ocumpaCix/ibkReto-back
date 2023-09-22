package com.ocumpave.conversormoneda.infraestructure.controller;

import com.ocumpave.conversormoneda.application.dto.request.ActualizarTasaCambioRequest;
import com.ocumpave.conversormoneda.application.dto.request.CambioMonedaRequest;
import com.ocumpave.conversormoneda.application.service.TipoCambioExternalService;
import com.ocumpave.conversormoneda.application.dto.response.AppResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/tc")
public class TipoCambioController {
    private final TipoCambioExternalService service;

    @GetMapping
    AppResponse listar() {
        return service.listar();
    }

    @PostMapping("cambiarMoneda")
    AppResponse cambiarMoneda(@Valid @RequestBody CambioMonedaRequest request, HttpServletResponse servletResponse) {
        return service.cambiarMoneda(request, servletResponse);
    }

    @PostMapping
    AppResponse actualizarTipoCambio(@Valid @RequestBody ActualizarTasaCambioRequest request,HttpServletResponse servletResponse){
        return service.actualizarTasaCambio(request,servletResponse);
    }
}
