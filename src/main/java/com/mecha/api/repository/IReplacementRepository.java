package com.mecha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mecha.api.model.Replacement;

public interface IReplacementRepository extends JpaRepository<Replacement, Long> {
    
}
