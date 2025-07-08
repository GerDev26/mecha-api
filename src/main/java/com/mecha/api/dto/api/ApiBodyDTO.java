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
public class ApiBodyDTO {
    private String message;
    private Object data;

    public ApiBodyDTO(String message) {
        this.message = message;
        this.data = new ArrayList<>();
    }
}
