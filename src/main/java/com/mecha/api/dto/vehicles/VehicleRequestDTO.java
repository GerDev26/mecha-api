package com.mecha.api.dto.vehicles;

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
public class VehicleRequestDTO {
    @NotNull(message = "The field brand is required", groups = Store.class)
    private String brand;
    @NotNull(message = "The field model is required", groups = Store.class)
    private String model;
}
