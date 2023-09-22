package com.ocumpave.conversormoneda.application.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppResponse {
    private boolean success;
    private String message;
    private List<InvalidFieldResponse> invalidFields;
    private Object data;

    public static AppResponse successResponse(Object data) {
        return AppResponse.builder()
                .success(true)
                .message("Operacion realizada con éxito")
                .data(data)
                .build();
    }

    public static AppResponse invalidFieldsResponse(List<InvalidFieldResponse> invalidFields) {
        return AppResponse.builder()
                .success(false)
                .message("Se han encontrado errores de validación")
                .invalidFields(invalidFields)
                .build();
    }
}
