package com.mecha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecha.api.model.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    
}
