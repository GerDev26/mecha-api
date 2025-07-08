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

import com.mecha.api.dto.api.ApiBodyDTO;
import com.mecha.api.model.Role;
import com.mecha.api.service.interfaces.IRoleService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    
    @GetMapping
    public ResponseEntity<ApiBodyDTO> index() {
        List<Role> roles = roleService.findAll();
        return ResponseEntity.ok(new ApiBodyDTO("Showing all Roles", roles));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> show(@PathVariable Long id) {
        Role role = roleService.findById(id);
        return ResponseEntity.ok(new ApiBodyDTO("Showing Role", role));
    }
    
    @PostMapping
    public ResponseEntity<ApiBodyDTO> store(@RequestBody Role role) {
        roleService.save(role);
        return ResponseEntity.created(null).body(new ApiBodyDTO("Role created successfully"));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> update(@PathVariable Long id, @RequestBody Role role) {
        roleService.update(id, role);
        return ResponseEntity.ok(new ApiBodyDTO("Role updated successfully"));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> destroy(@PathVariable Long id) {
        roleService.deleteById(id);
        return ResponseEntity.ok(new ApiBodyDTO("Role deleted successfully"));
    }
}
