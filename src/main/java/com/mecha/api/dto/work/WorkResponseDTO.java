package com.mecha.api.dto.work;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkResponseDTO {
    private Long id;
    private String name;
    private Double unit_price;
}
