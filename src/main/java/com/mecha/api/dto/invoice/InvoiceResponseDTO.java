package com.mecha.api.dto.invoice;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponseDTO {
    private Long id;
    private Double total_price;
    private LocalDate created_at;
    private LocalDate updated_at;
}
