package com.ocumpave.conversormoneda.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvalidFieldResponse {
    private String fieldName;
    private Object rejectedValue;
}
