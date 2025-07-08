package com.mecha.api.dto.AuthDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthRegisterRequestDTO {
    @NotBlank(message = "Email is required")
    private String email;
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    @NotBlank(message = "Lastname is required")
    private String lastname;
    
    @NotBlank(message = "Phone number is required")
    @Size(min = 10, message = "Phone number must be at least 10 characters long")
    private String phoneNumber;
}
