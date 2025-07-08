package com.mecha.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mecha.api.model.Vehicle;
import com.mecha.api.repository.IVehicleRepository;
import com.mecha.api.service.interfaces.IVehicleService;
import com.mecha.api.exceptions.NotFoundException;

@Service
public class VehicleService implements IVehicleService {
    
    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new NotFoundException("Vehicle not found"));
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle update(Long id, Vehicle vehicle) {
        Vehicle vehicleUpdated = this.findById(id);
        vehicleUpdated.setModel(vehicle.getModel());
        vehicleUpdated.setBrand(vehicle.getBrand());
        vehicleUpdated.setPersonalVehicles(vehicle.getPersonalVehicles());
        vehicleUpdated.setReplacements(vehicle.getReplacements());
        vehicleRepository.save(vehicleUpdated);
        return vehicleUpdated;
    }

    @Override
    public void deleteById(Long id) {
        Vehicle vehicle = this.findById(id);
        vehicleRepository.delete(vehicle);
    }
}
