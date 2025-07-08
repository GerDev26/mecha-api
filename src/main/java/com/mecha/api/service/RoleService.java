package com.mecha.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mecha.api.model.Role;
import com.mecha.api.repository.IRoleRepository;
import com.mecha.api.service.interfaces.IRoleService;
import com.mecha.api.exceptions.NotFoundException;

@Service
public class RoleService implements IRoleService {
    
    @Autowired
    private IRoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role save(Role role) {
        roleRepository.save(role);
        return role;
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new NotFoundException("Role not found"));
    }

    public void deleteById(Long id) {
        Role role = this.findById(id);
        roleRepository.delete(role);
    }
    
    public Role update(Long id, Role role) {
        Role roleUpdated = this.findById(id);
        roleUpdated.setName(role.getName());
        roleRepository.save(roleUpdated);
        return roleUpdated;
    }
}
