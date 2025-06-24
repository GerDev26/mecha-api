package com.mecha.api.service.interfaces;

import java.util.List;

import com.mecha.api.model.Role;

public interface IRoleService {
    public List<Role> findAll();
    public void save(Role role);
    public Role findById(Long id);
    public void deleteById(Long id);
    public void update(Long id, Role role);
}