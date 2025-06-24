package com.mecha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecha.api.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    
}
