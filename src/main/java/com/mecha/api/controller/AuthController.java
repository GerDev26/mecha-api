package com.mecha.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mecha.api.dto.AuthDTO.AuthLoginRequestDTO;
import com.mecha.api.dto.AuthDTO.AuthRegisterRequestDTO;
import com.mecha.api.dto.AuthDTO.AuthResponseDTO;
import com.mecha.api.model.AppUser;
import com.mecha.api.security.SecurityService;
import com.mecha.api.service.interfaces.IRoleService;
import com.mecha.api.service.interfaces.IAppUserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AuthController {
    
    @Autowired
    private SecurityService securityService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IAppUserService appUserService;

    //Todas estas requests y responses vamos a tratarlas como dto
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid AuthLoginRequestDTO userRequest) {
        return new ResponseEntity<>(this.securityService.loginUser(userRequest), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody AuthRegisterRequestDTO entity) {
        AppUser newUser = new AppUser();
        newUser.setEmail(entity.getEmail());
        newUser.setPassword(entity.getPassword());
        newUser.setAlias((entity.getName()));
        newUser.setName(entity.getName());
        newUser.setLastname(entity.getLastname());
        newUser.setPhoneNumber(entity.getPhoneNumber());
        newUser.setAccountNotExpired(true);
        newUser.setAccountNotLocked(true);
        newUser.setCredentialNotExpired(true);
        newUser.setEnabled(true);
        newUser.setRoles(List.of(roleService.findById(3L)));
        appUserService.save(newUser);
        return new ResponseEntity<>(this.securityService.loginUser(new AuthLoginRequestDTO(entity.getEmail(), entity.getPassword())), HttpStatus.OK);
    }
    @GetMapping("/customer")
    @PreAuthorize("hasRole('CUSTOMER')")
    public String helloCustomer() {
        return "Hello customer";
    }
    
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloAdmin() {
        return "Hello admin";
    }
    

}
