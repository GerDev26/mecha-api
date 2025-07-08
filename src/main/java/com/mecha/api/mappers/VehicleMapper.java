package com.mecha.api.mappers;

import org.springframework.stereotype.Component;

import com.mecha.api.dto.vehicles.VehicleRequestDTO;
import com.mecha.api.dto.vehicles.VehicleResponseDTO;
import com.mecha.api.model.Vehicle;

@Component
public class VehicleMapper implements IMapper<VehicleRequestDTO, VehicleResponseDTO, Vehicle> {
    
    public VehicleResponseDTO EntityToResponse(Vehicle vehicle) {
        VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO();
        vehicleResponseDTO.setId(vehicle.getId());
        vehicleResponseDTO.setBrand(vehicle.getBrand());
        vehicleResponseDTO.setModel(vehicle.getModel());
        return vehicleResponseDTO;
    }

    public Vehicle RequestToEntity(VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleRequestDTO.getBrand());
        vehicle.setModel(vehicleRequestDTO.getModel());
        return vehicle;
    }
}
