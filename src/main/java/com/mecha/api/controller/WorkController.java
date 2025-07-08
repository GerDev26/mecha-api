package com.mecha.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.mecha.api.dto.validations.Store;
import com.mecha.api.dto.validations.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.mecha.api.service.interfaces.IWorkService;

import com.mecha.api.dto.api.ApiBodyDTO;
import com.mecha.api.dto.work.WorkRequestDTO;
import com.mecha.api.dto.work.WorkResponseDTO;
import com.mecha.api.mappers.WorkMapper;
import com.mecha.api.model.Work;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/work")
public class WorkController {
    
    @Autowired
    private IWorkService workService;

    @Autowired
    private WorkMapper workMapper;
    
    @GetMapping
    public ResponseEntity<ApiBodyDTO> index() {
        List<WorkResponseDTO> works = workService.findAll().stream()
                .map(workMapper::EntityToResponse)
                .toList();
        return ResponseEntity.ok(new ApiBodyDTO("Showing all Works", works));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> show(@PathVariable Long id) {
        WorkResponseDTO work = workMapper.EntityToResponse(workService.findById(id));
        return ResponseEntity.ok(new ApiBodyDTO("Showing Work", work));
    }

    @PostMapping
    public ResponseEntity<ApiBodyDTO> store(@Validated(Store.class) @RequestBody WorkRequestDTO workRequestDTO) {
        Work work = workMapper.RequestToEntity(workRequestDTO);
        workService.save(work);
        return ResponseEntity.created(null).body(new ApiBodyDTO("Work created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> update(@PathVariable Long id, @Validated(Update.class) @RequestBody WorkRequestDTO workRequestDTO) {
        Work work = workMapper.RequestToEntity(workRequestDTO);
        workService.update(id, work);
        return ResponseEntity.ok(new ApiBodyDTO("Work updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> destroy(@PathVariable Long id) {
        workService.deleteById(id);
        return ResponseEntity.ok(new ApiBodyDTO("Work deleted successfully"));
    }
}