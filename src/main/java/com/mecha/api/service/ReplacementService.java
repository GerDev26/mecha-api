package com.mecha.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mecha.api.exceptions.NotFoundException;
import com.mecha.api.model.Replacement;
import com.mecha.api.repository.IReplacementRepository;
import com.mecha.api.service.interfaces.IReplacementService;

@Service
public class ReplacementService implements IReplacementService {
    @Autowired
    private IReplacementRepository replacementRepository;
    
    @Override
    public List<Replacement> findAll() {
        return replacementRepository.findAll();
    }
    
    @Override
    public Replacement save(Replacement replacement) {
        replacementRepository.save(replacement);
        return replacement;
    }
    
    @Override
    public Replacement findById(Long id) {
        return replacementRepository.findById(id).orElseThrow(() -> new NotFoundException("Replacement not found"));
    }
    
    @Override
    public void deleteById(Long id) {
        Replacement replacement = this.findById(id);
        replacementRepository.delete(replacement);
    }
    
    @Override
    public Replacement update(Long id, Replacement replacement) {
        Replacement replacementUpdated = this.findById(id);
        replacementUpdated.setName(replacement.getName());
        replacementUpdated.setUnit_price(replacement.getUnit_price());
        replacementUpdated.setVehicle(replacement.getVehicle());
        replacementUpdated.setInvoiceReplacements(replacement.getInvoiceReplacements());
        return replacementRepository.save(replacementUpdated);
    }
}
