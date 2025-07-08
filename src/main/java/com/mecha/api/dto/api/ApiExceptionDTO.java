package com.mecha.api.dto.api;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiExceptionDTO {
    private String message;
    private Object error;

    public ApiExceptionDTO(String message) {
        this.message = message;
        this.error = new ArrayList<>();
    }
}
