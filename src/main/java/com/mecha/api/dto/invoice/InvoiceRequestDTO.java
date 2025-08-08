package com.mecha.api.dto.invoice;

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
public class InvoiceRequestDTO {

    @NotNull(message = "The field total_price is required", groups = Store.class)
    private Double total_price;
}
