package com.mecha.api.dto.work;

import com.mecha.api.dto.validations.Store;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkRequestDTO {

    @NotNull(message = "The field name is required", groups = Store.class)
    private String name;

    @NotNull(message = "The field unit_price is required", groups = Store.class)
    private Double unit_price;
}
