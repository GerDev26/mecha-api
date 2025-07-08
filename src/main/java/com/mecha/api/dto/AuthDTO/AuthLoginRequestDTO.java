package com.mecha.api.dto.AuthDTO;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequestDTO (@NotBlank String email, @NotBlank String password) {
}
