package com.mecha.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.mecha.api.dto.api.ApiBodyDTO;
import com.mecha.api.model.Vehicle;
import com.mecha.api.service.interfaces.IVehicleService;
import com.mecha.api.dto.vehicles.VehicleRequestDTO;
import com.mecha.api.dto.vehicles.VehicleResponseDTO;
import com.mecha.api.mappers.VehicleMapper;
import com.mecha.api.service.interfaces.IReplacementService;
import com.mecha.api.dto.replacement.ReplacementResponseDTO;
import com.mecha.api.mappers.ReplacementMapper;
import com.mecha.api.model.Replacement;
import org.springframework.validation.annotation.Validated;
import com.mecha.api.dto.validations.Store;
import com.mecha.api.dto.validations.Update;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    
    @Autowired
    private IVehicleService vehicleService;
    
    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private ReplacementMapper replacementMapper;    
    
    @GetMapping
    public ResponseEntity<ApiBodyDTO> index() {
        List<Vehicle> vehicles = vehicleService.findAll();
        List<VehicleResponseDTO> vehiclesResponseDTO = vehicles.stream().map(vehicleMapper::EntityToResponse).toList();
        return ResponseEntity.ok(new ApiBodyDTO("Showing all Vehicles", vehiclesResponseDTO));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> show(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.findById(id);
        VehicleResponseDTO vehicleResponseDTO = vehicleMapper.EntityToResponse(vehicle);
        return ResponseEntity.ok(new ApiBodyDTO("Showing Vehicle", vehicleResponseDTO));
    }

    @GetMapping("/{id}/replacement")
    public ResponseEntity<ApiBodyDTO> showReplacements(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.findById(id);
        List<Replacement> replacements = vehicle.getReplacements();
        List<ReplacementResponseDTO> replacementsResponseDTO = replacements.stream().map(replacementMapper::EntityToResponse).toList();
        return ResponseEntity.ok(new ApiBodyDTO("Showing " + vehicle.getModel() + " Replacements", replacementsResponseDTO));
    }
    @PostMapping
    public ResponseEntity<ApiBodyDTO> store(@Validated(Store.class) @RequestBody VehicleRequestDTO vehicleRequestDTO) {
        Vehicle currentVehicle = vehicleMapper.RequestToEntity(vehicleRequestDTO);
        vehicleService.save(currentVehicle);
        return ResponseEntity.created(null).body(new ApiBodyDTO("Vehicle created successfully", vehicleMapper.EntityToResponse(currentVehicle)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> update(@PathVariable Long id, @Validated(Update.class) @RequestBody VehicleRequestDTO vehicleRequestDTO) {
        Vehicle currentVehicle = vehicleMapper.RequestToEntity(vehicleRequestDTO);
        vehicleService.update(id, currentVehicle);
        return ResponseEntity.ok(new ApiBodyDTO("Vehicle updated successfully", vehicleMapper.EntityToResponse(currentVehicle)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> destroy(@PathVariable Long id) {
        vehicleService.deleteById(id);
        return ResponseEntity.ok(new ApiBodyDTO("Vehicle deleted successfully"));
    }
}
