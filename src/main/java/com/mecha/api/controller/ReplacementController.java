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
import com.mecha.api.service.interfaces.IReplacementService;

import com.mecha.api.model.Replacement;
import com.mecha.api.dto.api.ApiBodyDTO;
import com.mecha.api.dto.replacement.ReplacementRequestDTO;
import com.mecha.api.dto.replacement.ReplacementResponseDTO;
import com.mecha.api.mappers.ReplacementMapper;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/replacement")
public class ReplacementController {
    
    @Autowired
    private IReplacementService replacementService;

    @Autowired
    private ReplacementMapper replacementMapper;    
    
    @GetMapping
    public ResponseEntity<ApiBodyDTO> index() {
        List<Replacement> replacements = replacementService.findAll();
        List<ReplacementResponseDTO> replacementsResponseDTO = replacements.stream().map(replacementMapper::EntityToResponse).toList();
        return ResponseEntity.ok(new ApiBodyDTO("Showing all Replacements", replacementsResponseDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> show(@PathVariable Long id) {
        Replacement replacement = replacementService.findById(id);
        return ResponseEntity.ok(new ApiBodyDTO("Showing Replacement", replacementMapper.EntityToResponse(replacement)));
    }

    @PostMapping
    public ResponseEntity<ApiBodyDTO> store(@Validated(Store.class) @RequestBody ReplacementRequestDTO storeReplacementDTO) {
        Replacement replacement = replacementMapper.RequestToEntity(storeReplacementDTO);
        replacementService.save(replacement);
        return ResponseEntity.created(null).body(new ApiBodyDTO("Replacement created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> update(@PathVariable Long id, @Validated(Update.class) @RequestBody ReplacementRequestDTO updateReplacementDTO) {
        Replacement replacement = replacementMapper.RequestToEntity(updateReplacementDTO);
        replacementService.update(id, replacement);
        return ResponseEntity.ok(new ApiBodyDTO("Replacement updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> destroy(@PathVariable Long id) {
        replacementService.deleteById(id);
        return ResponseEntity.ok(new ApiBodyDTO("Replacement deleted successfully"));
    }
}
