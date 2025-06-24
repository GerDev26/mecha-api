package com.mecha.api.controller.v1;

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

import com.mecha.api.model.Role;
import com.mecha.api.service.interfaces.IRoleService;

@RestController
@RequestMapping("role")
@PreAuthorize("hasRole('ADMIN')")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    
    @GetMapping
    public List<Role> index() {
        return roleService.findAll();
    }
    
    @GetMapping("/{id}")
    public Role show(@PathVariable Long id) {
        return roleService.findById(id);
    }
    
    @PostMapping
    public void store(@RequestBody Role role) {
        roleService.save(role);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Role role) {
        roleService.update(id, role);
    }
    
    @DeleteMapping("/{id}")
    public void destroy(@PathVariable Long id) {
        roleService.deleteById(id);
    }
}
