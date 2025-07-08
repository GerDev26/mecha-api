package com.mecha.api.dto.replacement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplacementResponseDTO {
    private Long id;
    private String name;
    private Double price;
    private String vehicle;
}
