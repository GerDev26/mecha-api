package com.mecha.api.mappers;

import org.springframework.stereotype.Component;

import com.mecha.api.dto.work.WorkRequestDTO;
import com.mecha.api.dto.work.WorkResponseDTO;
import com.mecha.api.model.Work;

@Component
public class WorkMapper implements IMapper<WorkRequestDTO, WorkResponseDTO, Work> {
    
    @Override
    public Work RequestToEntity(WorkRequestDTO workRequestDTO) {
        Work work = new Work();
        work.setName(workRequestDTO.getName());
        work.setUnit_price(workRequestDTO.getUnit_price());
        return work;
    }

    @Override
    public WorkResponseDTO EntityToResponse(Work work) {
        WorkResponseDTO workResponseDTO = new WorkResponseDTO();
        workResponseDTO.setId(work.getId());
        workResponseDTO.setName(work.getName());
        workResponseDTO.setUnit_price(work.getUnit_price());
        return workResponseDTO;
    }
}
