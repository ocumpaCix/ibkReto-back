package com.ocumpave.conversormoneda.infraestructure.config;

import com.ocumpave.conversormoneda.application.dto.response.AppResponse;
import com.ocumpave.conversormoneda.application.dto.response.InvalidFieldResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<AppResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var errorList = new ArrayList<InvalidFieldResponse>();
        var errors = ex.getFieldErrors();
        for (var err : errors) {
            errorList.add(new InvalidFieldResponse(err.getField(), err.getRejectedValue()));
        }
        return ResponseEntity.badRequest()
                .body(AppResponse.invalidFieldsResponse(errorList));
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<AppResponse> handleException(Exception ex) {
        return ResponseEntity.internalServerError()
                .body(AppResponse.builder()
                        .success(false)
                        .message("se ha producido un error:" + ex.getMessage())
                        .build());
    }

}
