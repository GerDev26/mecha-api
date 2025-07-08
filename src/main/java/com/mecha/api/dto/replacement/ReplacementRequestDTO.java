package com.mecha.api.dto.replacement;

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
public class ReplacementRequestDTO {

    @NotNull(message = "The field name is required", groups = Store.class)
    private String name;

    @NotNull(message = "The field price is required", groups = Store.class)
    private Double price;

    @NotNull(message = "The field vehicle_id is required", groups = Store.class)
    private Long vehicle_id;
}
