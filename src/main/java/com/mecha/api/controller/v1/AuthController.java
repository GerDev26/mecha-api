package com.mecha.api.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mecha.api.dto.AuthLoginRequestDTO;
import com.mecha.api.dto.AuthResponseDTO;
import com.mecha.api.security.SecurityService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("auth")
public class AuthController {
    
    @Autowired
    private SecurityService securityService;

    //Todas estas requests y responses vamos a tratarlas como dto
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid AuthLoginRequestDTO userRequest) {
        return new ResponseEntity<>(this.securityService.loginUser(userRequest), HttpStatus.OK);
    }

}
