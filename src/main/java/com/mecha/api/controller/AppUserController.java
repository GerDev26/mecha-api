package com.mecha.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mecha.api.model.AppUser;
import com.mecha.api.dto.api.ApiBodyDTO;
import com.mecha.api.service.interfaces.IAppUserService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("user")
public class AppUserController {

    @Autowired
    private IAppUserService appUserService;

    @GetMapping
    public ResponseEntity<ApiBodyDTO> index() {
        List<AppUser> users = appUserService.findAll();
        return ResponseEntity.ok(new ApiBodyDTO("Showing all Users", users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> show(@PathVariable Long id) {
        AppUser user = appUserService.findById(id);
        return ResponseEntity.ok(new ApiBodyDTO("Showing User", user));
    }
    
    @PostMapping
    public ResponseEntity<ApiBodyDTO> store(@RequestBody AppUser appUser) {
        appUserService.save(appUser);
        return ResponseEntity.created(null).body(new ApiBodyDTO("User created successfully"));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> update(@PathVariable Long id, @RequestBody AppUser appUser) {
        appUserService.update(id, appUser);
        return ResponseEntity.ok(new ApiBodyDTO("User updated successfully"));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> destroy(@PathVariable Long id) {
        appUserService.deleteById(id);
        return ResponseEntity.ok(new ApiBodyDTO("User deleted successfully"));
    }

}
