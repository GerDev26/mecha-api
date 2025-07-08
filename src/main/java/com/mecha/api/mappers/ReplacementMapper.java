package com.mecha.api.mappers;

import org.springframework.stereotype.Component;

import com.mecha.api.dto.replacement.ReplacementRequestDTO;
import com.mecha.api.dto.replacement.ReplacementResponseDTO;
import com.mecha.api.model.Replacement;
import com.mecha.api.model.Vehicle;

@Component
public class ReplacementMapper implements IMapper<ReplacementRequestDTO, ReplacementResponseDTO, Replacement> {
    
    public Replacement RequestToEntity(ReplacementRequestDTO storeReplacementDTO) {

        Vehicle createdVehicle = new Vehicle();
        createdVehicle.setId(storeReplacementDTO.getVehicle_id());

        Replacement replacement = new Replacement();
        replacement.setName(storeReplacementDTO.getName());
        replacement.setUnit_price(storeReplacementDTO.getPrice());
        replacement.setVehicle(createdVehicle);
        return replacement;
    }
    public ReplacementResponseDTO EntityToResponse(Replacement replacement) {
        ReplacementResponseDTO replacementResponseDTO = new ReplacementResponseDTO();
        replacementResponseDTO.setId(replacement.getId());
        replacementResponseDTO.setName(replacement.getName());
        replacementResponseDTO.setPrice(replacement.getUnit_price());
        replacementResponseDTO.setVehicle(replacement.getVehicle().getModel());
        return replacementResponseDTO;
    }
}
